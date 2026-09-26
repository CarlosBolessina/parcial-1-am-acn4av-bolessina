package com.example.miapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;

import android.widget.Spinner;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nombre = findViewById(R.id.edtNombre);
        EditText tempo = findViewById(R.id.edtTempo);
        EditText idea = findViewById(R.id.edtIdea);

        Button guardar = findViewById(R.id.btnGuardar);
        Button limpiar = findViewById(R.id.btnLimpiar);



        Spinner instrumento = findViewById(R.id.spinnerInstrumento);
        String[] instrumentos = {
                "Piano",
                "Guitarra",
                "Bajo",
                "Violín",
                "Batería"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                instrumentos
        );
        instrumento.setAdapter(adapter);

        Spinner tonalidad = findViewById(R.id.spinnerTonalidad);

        String[] tonalidades = {
                "Do",
                "Re",
                "Mi",
                "Fa",
                "Sol",
                "La",
                "Si"
        };

        ArrayAdapter<String> adapterTonalidad = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tonalidades
        );

        tonalidad.setAdapter(adapterTonalidad);

        guardar.setOnClickListener(v -> {

            String nombreTexto = nombre.getText().toString();
            String tempoTexto = tempo.getText().toString();
            String ideaTexto = idea.getText().toString();

            String mensaje = "Composición: " + nombreTexto
                    + "\nInstrumento: " + instrumento.getSelectedItem().toString()
                    + "\nTonalidad: " + tonalidad.getSelectedItem().toString()
                    + "\nTempo: " + tempoTexto
                    + "\nIdea: " + ideaTexto;

            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        });

        limpiar.setOnClickListener(v -> {

            nombre.setText("");
            tempo.setText("");
            idea.setText("");

            instrumento.setSelection(0);
            tonalidad.setSelection(0);
        });
    }
}