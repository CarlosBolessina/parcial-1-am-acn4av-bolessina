package com.example.miapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;

import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}