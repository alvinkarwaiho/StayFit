package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Stepcounter extends AppCompatActivity  {
    private SensorManager manageSensor;
    private TextView info;
    private TextView steps;
    private Integer count=0;
    private double previousMag=0;
    private double size;
    private double sizeDelta;
    private float accelerate_x;
    private float accelerate_y;
    private float accelerate_z;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stepcounter);


            steps = findViewById(R.id.steps);
            SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


            SensorEventListener detectStep = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent!= null){
                        accelerate_x = sensorEvent.values[0];
                        accelerate_y = sensorEvent.values[1];
                        accelerate_z = sensorEvent.values[2];

                         size = Math.sqrt(accelerate_x*accelerate_x + accelerate_y*accelerate_y + accelerate_z*accelerate_z);
                         sizeDelta = size - previousMag;
                        previousMag = size;



                        if (sizeDelta > 6){
                            count++;
                        }
                        steps.setText(count.toString());
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            };

            sensorManager.registerListener(detectStep, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }


    }


