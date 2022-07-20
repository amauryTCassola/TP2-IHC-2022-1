package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EX2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex22);

        TextView ed1 = (TextView) findViewById(R.id.textView5);
        String msg = getIntent().getStringExtra("data");
        ed1.setText("Mensagem: "+msg);
    }

    public void proximoExercicio(View view){
        Intent i = new Intent(this, EX3_1.class);
        startActivity(i);
    }
}