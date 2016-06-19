package com.example.guillo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String nombre = extras.getString("nombre");
            String telefono = extras.getString("telefono");
            String correo = extras.getString("correo");
            String descripcion = extras.getString("descripcion");

            int mes = 0;
            switch (extras.getString("mes")) {
                case "Jan":
                    mes = 0;
                    break;
                case "Feb":
                    mes = 1;
                    break;
                case "Mar":
                    mes = 2;
                    break;
                case "Apr":
                    mes = 3;
                    break;
                case "May":
                    mes = 4;
                    break;
                case "Jun":
                    mes = 5;
                    break;
                case "Jul":
                    mes = 6;
                    break;
                case "Aug":
                    mes = 7;
                    break;
                case "Sep":
                    mes = 8;
                    break;
                case "Oct":
                    mes = 9;
                    break;
                case "Nov":
                    mes = 10;
                    break;
                case "Dec":
                    mes = 11;
                    break;
            }

            int dia = Integer.parseInt(extras.getString("dia"));
            int anio = Integer.parseInt(extras.getString("anio"));

            EditText editTextNombre = (EditText) findViewById(R.id.editTextNombre);
            EditText editTextTelefono = (EditText) findViewById(R.id.editTextTelefono);
            EditText editTextCorreo = (EditText) findViewById(R.id.editTextCorreo);
            EditText editTextDescripcion = (EditText) findViewById(R.id.editTextDescripcion);
            DatePicker datePickerCalendario = (DatePicker) findViewById(R.id.datePickerCalendario);

            editTextNombre.setText(nombre);
            editTextTelefono.setText(telefono);
            editTextCorreo.setText(correo);
            editTextDescripcion.setText(descripcion);
            datePickerCalendario.init(anio, mes, dia, null);
        }
    }


    public void irSiguiente(View view) {
        EditText editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        EditText editTextTelefono = (EditText) findViewById(R.id.editTextTelefono);
        EditText editTextCorreo = (EditText) findViewById(R.id.editTextCorreo);
        EditText editTextDescripcion = (EditText) findViewById(R.id.editTextDescripcion);
        DatePicker datePickerCalendario = (DatePicker)findViewById(R.id.datePickerCalendario);

        String[] nombreMes = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String anio = Integer.toString(datePickerCalendario.getYear());
        String mes = nombreMes[datePickerCalendario.getMonth()];
        String dia = Integer.toString(datePickerCalendario.getDayOfMonth());

        String nombre = editTextNombre.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String correo = editTextCorreo.getText().toString();
        String descripcion = editTextDescripcion.getText().toString();

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("nombre", nombre);
        i.putExtra("telefono", telefono);
        i.putExtra("correo", correo);
        i.putExtra("descripcion", descripcion);
        i.putExtra("dia", dia);
        i.putExtra("mes", mes);
        i.putExtra("anio", anio);

        startActivity(i);
    }
}
