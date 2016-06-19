package com.example.guillo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String telefono = extras.getString("telefono");
        String correo = extras.getString("correo");
        String descripcion = extras.getString("descripcion");
        String dia = extras.getString("dia");
        String mes = extras.getString("mes");
        String anio = extras.getString("anio");

        TextView textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        TextView textViewCorreo = (TextView) findViewById(R.id.textViewCorreo);
        TextView textViewTelefono = (TextView) findViewById(R.id.textViewTelefono);
        TextView textViewDescripcion = (TextView) findViewById(R.id.textViewDescripcion);
        TextView textViewCalendario = (TextView) findViewById(R.id.textViewCalendario);

        textViewNombre.append(nombre);
        textViewCorreo.append(telefono);
        textViewTelefono.append(correo);
        textViewDescripcion.append(descripcion);
        textViewCalendario.append(dia + "/" + mes + "/" + anio);
    }

    public void editar(View view) {
        TextView textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        TextView textViewTelefono = (TextView) findViewById(R.id.textViewTelefono);
        TextView textViewCorreo = (TextView) findViewById(R.id.textViewCorreo);
        TextView textViewDescripcion = (TextView) findViewById(R.id.textViewDescripcion);
        TextView textViewCalendario = (TextView) findViewById(R.id.textViewCalendario);

        String nombre = textViewNombre.getText().toString();
        String telefono = textViewTelefono.getText().toString();
        String correo = textViewCorreo.getText().toString();
        String descripcion = textViewDescripcion.getText().toString();
        String fecha = textViewCalendario.getText().toString();

        String[] diaMesAnio = fecha.split("/");
        String dia = diaMesAnio[0];
        String mes = diaMesAnio[1];
        String anio = diaMesAnio[2];

        Intent i = new Intent(this, MainActivity.class);
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
