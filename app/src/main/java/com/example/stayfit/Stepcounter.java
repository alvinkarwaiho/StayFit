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
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stepcounter extends AppCompatActivity {
    private SensorManager manageSensor;
    private TextView info;
    private TextView steps;
    private Integer count = 0;
    private float accelerate_x;
    private float accelerate_y;
    private float accelerate_z;
    private double previousMag = 0;
    private double size;
    private double sizeDelta;
    private String save;
    private String information;

    private FloatingActionButton saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);
        info = findViewById(R.id.info2);
        open("stepcounter.txt");
        info.setText(information);
        steps = findViewById(R.id.steps);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        saveButton = findViewById(R.id.saveButton);

        SensorEventListener detectStep = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    accelerate_x = sensorEvent.values[0];
                    accelerate_y = sensorEvent.values[1];
                    accelerate_z = sensorEvent.values[2];

                    size = Math.sqrt(accelerate_x * accelerate_x + accelerate_y * accelerate_y + accelerate_z * accelerate_z);
                    sizeDelta = size - previousMag;
                    previousMag = size;


                    if (sizeDelta > 6) {
                        count++;
                    }
                    save = count.toString();
                    steps.setText(count.toString());

                    save("stepcounter.txt");

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        sensorManager.registerListener(detectStep, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }
    public String save(final String name) {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(name, 0));
                    outputStreamWriter.write(save);
                    outputStreamWriter.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
                info.setText(save);
            }
        });
        return save;
    }
    public String open(final String name) {
         information="";
        try{
        InputStream open = openFileInput(name);
        InputStreamReader inputStreamReader = new InputStreamReader(open);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String local="";
        while((local = br.readLine()) != null){
            sb.append(local);
        }inputStreamReader.close();
        information = sb.toString();
        }catch (FileNotFoundException fileNot){
            fileNot.printStackTrace();
        }
        catch(IOException io ){
            io.printStackTrace();
        }
  //      info.setText(information);
        return information;
    }

}

