package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EX4 extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor mLight;
    private Sensor mTemp;

    TextView textLumens;
    TextView textTemp;
    TextView textLong;
    TextView textLat;
    Button getGPSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mTemp = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        textLumens = (TextView) findViewById(R.id.textViewLumens);
        textTemp = (TextView) findViewById(R.id.textViewTemp);
        textLat = (TextView) findViewById(R.id.textViewLatitude);
        textLong = (TextView) findViewById(R.id.textViewLongitude);

        getGPSBtn = (Button) findViewById(R.id.getGPSBtn);
        ActivityCompat.requestPermissions(EX4.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();

                    textLat.setText("Latitude: "+lat);
                    textLong.setText("Longitude: "+longi);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mTemp, SensorManager.SENSOR_DELAY_NORMAL);
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
            //coordX.setText("X: "+String.valueOf(sensorX));
            //coordY.setText("Y: "+String.valueOf(sensorY));
            //coordZ.setText("Z: "+String.valueOf(sensorZ));

            //if(Math.abs(sensorX) >= 10 || Math.abs(sensorY) >= 10 || Math.abs(sensorZ) >= 10){
            //    proximaActivity();
            //}
        }

        if(event.sensor.getType()== Sensor.TYPE_LIGHT){
            textLumens.setText("Luminosidade: "+String.valueOf((float)event.values[0]));
        }

        if(event.sensor.getType()== Sensor.TYPE_AMBIENT_TEMPERATURE){
            textTemp.setText("Temperatura: "+String.valueOf((float)event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}