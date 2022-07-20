package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EX3_1 extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    EditText coordX, coordY, coordZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex31);

        coordX = (EditText) findViewById(R.id.editTextCoordX);
        coordY = (EditText) findViewById(R.id.editTextCoordY);
        coordZ = (EditText) findViewById(R.id.editTextCoordZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            coordX.setText("X: "+String.valueOf(sensorX));
            coordY.setText("Y: "+String.valueOf(sensorY));
            coordZ.setText("Z: "+String.valueOf(sensorZ));

            if(Math.abs(sensorX) >= 10 || Math.abs(sensorY) >= 10 || Math.abs(sensorZ) >= 10){
                proximaActivity();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }

    public void proximaActivity(){
        Intent i = new Intent(this, EX3_2.class);
        startActivity(i);
    }

    public void proximoExercicio4(View view){
        Intent i = new Intent(this, EX4.class);
        startActivity(i);
    }
}