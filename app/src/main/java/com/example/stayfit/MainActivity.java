package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button cardio;
    private Button weightlifting;
    private Button features;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent (this, MainActivity.class);

        cardio =(Button) findViewById(R.id.cardio1);
        weightlifting = (Button) findViewById(R.id.weightlifting2);
        features = (Button) findViewById(R.id.features);

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
