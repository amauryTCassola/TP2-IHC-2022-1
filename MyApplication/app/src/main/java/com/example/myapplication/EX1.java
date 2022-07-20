package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EX1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view){
        EditText et1 = (EditText) findViewById(R.id.editTextNumber);
        EditText et2 = (EditText) findViewById(R.id.editTextNumber2);

        TextView txt = (TextView) findViewById(R.id.textView);

        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());
        int resultado = valor1 + valor2;

        txt.setText("RESULTADO: "+resultado);
    }

    public void proximoExercicio(View view){
        Intent i = new Intent(this, EX2_1.class);
        startActivity(i);
    }
}