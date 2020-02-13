package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class Weightlifting extends AppCompatActivity {
    Button chest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightlifting);
        chest = (Button) findViewById(R.id.chest);

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chest();
            }
        });
    }
        public void Chest (){
            Intent intent = new Intent(this, Chest.class);
            startActivity(intent);
        }



}
