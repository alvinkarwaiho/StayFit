package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton cardio;
    private ImageButton weightlifting;
    private ImageButton features;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardio =(ImageButton) findViewById(R.id.cardio1);
        weightlifting = (ImageButton) findViewById(R.id.weightlifting2);
        features = (ImageButton) findViewById(R.id.features);

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardio();
            }
        });
        weightlifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               weightlifting();
            }
        });
        features.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                features();
            }
        });

    }
    public void cardio(){
        Intent intent = new Intent(this, Cardio.class);
        startActivity(intent);
    }
    public void weightlifting(){
        Intent intent1 = new Intent(this, Weightlifting.class);
        startActivity(intent1);
    }
    public void features(){
        Intent intent2 = new Intent(this,Features.class);
        startActivity(intent2);

    }

}
