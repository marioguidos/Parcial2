package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class AddTransaction extends AppCompatActivity {

    EditText date_in;
    Spinner opciones;
    Button btnAdd,btnMmostrar;
    EditText txtFac,txtfecha,txtMonto, txtKM;
    TextView txvConsulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        //set controls objects
        txvConsulta=findViewById(R.id.txvConsultar);
        txtFac = (EditText) findViewById(R.id.txtFac);
        txtfecha = (EditText) findViewById(R.id.date_input);
        txtMonto = (EditText) findViewById(R.id.txtMonto);
        txtKM = (EditText) findViewById(R.id.txtKM);
        btnAdd = (Button) findViewById(R.id.btnAgregar);
        opciones = (Spinner) findViewById(R.id.spnCombustible);
        //DateTimePicker setUp
        date_in=findViewById(R.id.date_input);
        date_in.setInputType(InputType.TYPE_NULL);
        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });
    btnAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AppBaseGas db= Room.databaseBuilder(AddTransaction.this,AppBaseGas
            .class,"dbregistro").allowMainThreadQueries().build();

            Registro registro=new Registro(
                    Integer.parseInt(txtFac.getText().toString()),
                    txtfecha.getText().toString(),
                    opciones.getSelectedItem().toString(),
                    Double.parseDouble(txtMonto.getText().toString()),
                    Integer.parseInt(txtKM.getText().toString())
            );
            Long reg= db.registroDao().insert(registro);
            Toast.makeText(getApplicationContext(),
                    "Registro almacenado correctamente",
                    Toast.LENGTH_SHORT).show();
        }
    });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    btnMmostrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AppBaseGas db= Room.databaseBuilder(AddTransaction.this,
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
            txvConsulta.setText(valores);
        }
    });

    }
    private void showDateDialog(final EditText date_in) {
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
        new DatePickerDialog(AddTransaction.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void limpiar(){
        txtKM.setText("");
        txtMonto.setText("");
        txtfecha.setText("");
        txtFac.setText("");
    }
}