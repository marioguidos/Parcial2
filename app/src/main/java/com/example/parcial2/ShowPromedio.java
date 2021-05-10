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
        for(int i=0; i<lista.size();i++){
            //Concatenar los resultados
            valores += "ID: "+lista.get(i).idFactura+": "+
                    lista.get(i).numeroFac+" numeroFac:"+
                    lista.get(i).fecha + "fecha: " +
                    lista.get(i).tipoCom+" tipoCombu:"+
                    lista.get(i).montoCom + "monto: " +
                    lista.get(i).ktm + "\n";
        }//Fin del FOR
        //Asignar el acumulador al textview de los resultados
        Toast.makeText(getApplicationContext(),valores,Toast.LENGTH_LONG).show();
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