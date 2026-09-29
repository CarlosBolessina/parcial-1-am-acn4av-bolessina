package com.example.miapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;

import android.widget.Spinner;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import android.widget.TextView;

import android.widget.LinearLayout;

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
        Button agregarInstrumento = findViewById(R.id.btnAgregarInstrumento);
        LinearLayout contenedorInstrumentos = findViewById(R.id.contenedorInstrumentos);





        Spinner genero = findViewById(R.id.spinnerGenero);

        String[] generos = {
                "Rock",
                "Pop",
                "Jazz",
                "Electrónica",
                "Folklore",
                "Otro"
        };

        ArrayAdapter<String> adapterGenero = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                generos
        );

        genero.setAdapter(adapterGenero);

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

            if (nombreTexto.trim().isEmpty()) {
                Toast.makeText(this,
                        "Ingresá un nombre para el proyecto",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String tempoTexto = tempo.getText().toString();
            String ideaTexto = idea.getText().toString();


            if (contenedorInstrumentos.getChildCount() == 0) {
                Toast.makeText(this,
                        "Agregá al menos un instrumento",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            String instrumentosTexto = "";

            for (int i = 0; i < contenedorInstrumentos.getChildCount(); i++) {

                TextView tv = (TextView) contenedorInstrumentos.getChildAt(i);

                instrumentosTexto += tv.getText().toString();

                if (i < contenedorInstrumentos.getChildCount() - 1) {
                    instrumentosTexto += ", ";
                }
            }

            String mensaje = "Proyecto creado: " + nombreTexto
                    + "\nGénero: " + genero.getSelectedItem().toString()
                    + "\nInstrumentos: " + instrumentosTexto
                    + "\nTonalidad: " + tonalidad.getSelectedItem().toString()
                    + "\nTempo: " + tempoTexto
                    + "\nIdea: " + ideaTexto;

            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        });

        agregarInstrumento.setOnClickListener(v -> {

            String instrumentoSeleccionado =
                    instrumento.getSelectedItem().toString();

            TextView nuevoInstrumento = new TextView(this);

            String simbolo = "🎵";

            if (instrumentoSeleccionado.equals("Piano")) {
                simbolo = "🎹";
            } else if (instrumentoSeleccionado.equals("Guitarra")) {
                simbolo = "🎸";
            } else if (instrumentoSeleccionado.equals("Bajo")) {
                simbolo = "🎸";
            } else if (instrumentoSeleccionado.equals("Violín")) {
                simbolo = "🎻";
            } else if (instrumentoSeleccionado.equals("Batería")) {
                simbolo = "🥁";
            }

            nuevoInstrumento.setText(simbolo + " " + instrumentoSeleccionado);
            nuevoInstrumento.setTextSize(16);

            nuevoInstrumento.setPadding(16, 12, 16, 12);

            LinearLayout.LayoutParams parametros =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            parametros.setMargins(0, 0, 0, 8);

            nuevoInstrumento.setLayoutParams(parametros);

            nuevoInstrumento.setBackgroundResource(
                    android.R.drawable.editbox_background
            );

            contenedorInstrumentos.addView(nuevoInstrumento);
        });

        limpiar.setOnClickListener(v -> {

            nombre.setText("");
            tempo.setText("");
            idea.setText("");

            instrumento.setSelection(0);
            tonalidad.setSelection(0);
            contenedorInstrumentos.removeAllViews();
        });
    }
}