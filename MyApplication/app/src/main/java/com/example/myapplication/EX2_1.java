package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EX2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex21);
    }

    public void enviar(View view){
        Intent i = new Intent(this, EX2_2.class);
        EditText et1 = (EditText) findViewById(R.id.editTextText);
        i.putExtra("data", et1.getText().toString());
        startActivity(i);
    }

    public void proximoExercicio(View view){
        Intent i = new Intent(this, EX3_1.class);
        startActivity(i);
    }
}