package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShowPromedio extends AppCompatActivity {

    EditText date_in;
    EditText datefinal_in;
    ListView listViewPromedio;
    List<Promedio> lst;
    private SearchView searchView;
    public int lengthD = 0,lengthR = 0,lengthP = 0;
    public double costoAcumD=0, kmAcumD=0;
    public double costoAcumR=0, kmAcumR=0;
    public double costoAcumP=0, kmAcumP=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_promedio);

        searchView = findViewById(R.id.svBuscar);
        date_in = findViewById(R.id.date_input);
        datefinal_in = findViewById(R.id.datefin_input);
        date_in.setInputType(InputType.TYPE_NULL);
        datefinal_in.setInputType(InputType.TYPE_NULL);

        listViewPromedio = findViewById(R.id.lvPromedios);

        CustomAdapter adapter = new CustomAdapter(this,GetData());
        listViewPromedio.setAdapter(adapter);
        listViewPromedio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Promedio p = lst.get(position);

                Toast.makeText(getBaseContext(),p.titulo,Toast.LENGTH_SHORT).show();

            }
        });

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

    }

    private List<Promedio> GetData() {
        AppBaseGas db= Room.databaseBuilder(ShowPromedio.this,
                AppBaseGas.class,"dbregistro").allowMainThreadQueries().build();

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

        lst = new ArrayList<>();
        lst.add(new Promedio(1,"DIESEL", R.drawable.arriba, (kmAcumD/lengthD), R.drawable.cash,(costoAcumD/lengthD)));
        lst.add(new Promedio(2,"PREMIUM", R.drawable.arriba, (kmAcumP/lengthP), R.drawable.cash,(costoAcumP/lengthP)));
        lst.add(new Promedio(3,"REGULAR", R.drawable.arriba, (kmAcumR/lengthR), R.drawable.cash,(costoAcumR/lengthR)));
        return  lst;
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