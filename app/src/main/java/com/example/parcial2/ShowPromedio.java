package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShowPromedio extends AppCompatActivity {

    EditText date_in;
    EditText datefinal_in;
    RecyclerView listaFactura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_promedio);
        date_in = findViewById(R.id.date_input);
        datefinal_in = findViewById(R.id.datefin_input);
        date_in.setInputType(InputType.TYPE_NULL);
        datefinal_in.setInputType(InputType.TYPE_NULL);


        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });

        datefinal_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog2(datefinal_in);
            }
        });
        AppBaseGas db= Room.databaseBuilder(ShowPromedio.this,
                AppBaseGas.class,"dbregistro").allowMainThreadQueries().build();

        //Consultando registros de la base de datos
        List<Registro> lista = db.registroDao().getAll();
        String valores = "";
        //Recorrer la lista de los registros
        int lengthD = 0,lengthR = 0,lengthP = 0;
        double costoAcumD=0, kmAcumD=0;
        double costoAcumR=0, kmAcumR=0;
        double costoAcumP=0, kmAcumP=0;
        for(int i=0; i<lista.size();i++){
            if(lista.get(i).tipoCom.equals("Diesel")){
                costoAcumD = costoAcumD +lista.get(i).montoCom;
                kmAcumD = kmAcumD + lista.get(i).ktm;
                lengthD++;
            }else if(lista.get(i).tipoCom.equals("Regular")){
                costoAcumR = costoAcumR +lista.get(i).montoCom;
                kmAcumR = kmAcumR + lista.get(i).ktm;
                lengthR++;
            }else if(lista.get(i).tipoCom.equals("Premiun")){
                costoAcumP = costoAcumP +lista.get(i).montoCom;
                kmAcumP = kmAcumP + lista.get(i).ktm;
                lengthP++;
            }

        }//Fin del FOR
        //Asignar el acumulador al textview de los resultados
        Toast.makeText(getApplicationContext(),"Costo diesel promedio"+(costoAcumD/lengthD)+" KM disel promedio: "+(kmAcumD/lengthD),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Costo Regualr promedio"+(costoAcumR/lengthR)+" KM disel promedio: "+(kmAcumR/lengthR),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Costo Premium promedio"+(costoAcumP/lengthP)+" KM disel promedio: "+(kmAcumP/lengthP),Toast.LENGTH_LONG).show();
    }



    private void showDateDialog(final EditText date_in){
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(com.example.parcial2.ShowPromedio.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showDateDialog2(final EditText datefinal_in){
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                datefinal_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(com.example.parcial2.ShowPromedio.this,dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}