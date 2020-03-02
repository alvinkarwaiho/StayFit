package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class Weightlifting extends AppCompatActivity {
    Button chest;
    Button dip;
    Button curl;
    Button squats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightlifting);
        chest = (Button) findViewById(R.id.chest);
        dip = (Button) findViewById(R.id.tricep);
        curl =(Button) findViewById(R.id.curl);
        squats= (Button) findViewById(R.id.squats);

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chest();
            }
        });
        dip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weightlifting();
            }
        });
        curl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Curl();
            }
        });
        squats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squats();
            }
        });
    }
        public void Chest (){
            Intent intent = new Intent(this, Chest.class);
            startActivity(intent);
        }
        public void Weightlifting(){
        Intent intent = new Intent(this,Dip.class);
        startActivity(intent);
        }
        public void Curl(){
        Intent intent = new Intent(this, Curl.class);
        startActivity(intent);
        }
        public void squats(){
        Intent intent = new Intent(this, Squats.class);
        startActivity(intent);
        }




}
