package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Stepcounter extends AppCompatActivity implements SensorEventListener {
    SensorManager manageSensor;
    TextView info;
    TextView steps;
    boolean active = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);
        info = (TextView) findViewById(R.id.info);
        steps = (TextView) findViewById(R.id.stepCounter);

        manageSensor = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }
    public void onResume(){
        super.onResume();
        active = true;
        Sensor count = manageSensor.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if(count != null){
            manageSensor.registerListener(this, count , manageSensor.SENSOR_DELAY_UI);
        }else{
            Toast.makeText(this,"Failed to find sensor",Toast.LENGTH_SHORT).show();

        }

    }
    public void onPause(){
        super.onPause();
        active = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(active){
            steps.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
