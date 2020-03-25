package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Features extends AppCompatActivity {
    private Button step;
    private Button calorie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        step = (Button) findViewById(R.id.stepCounter);
        calorie = (Button) findViewById(R.id.calorieCounter);
        step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepCounter();
            }
        });
        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calorieCounter();
            }
        });
    }
    public void stepCounter(){

        Intent intent = new Intent(this, Stepcounter.class);
        startActivity(intent);
    }
    public void calorieCounter(){
        Intent intent = new Intent(this, Caloriecounter.class);
        startActivity(intent);
    }
}
