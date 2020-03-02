package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Cardio extends AppCompatActivity {
Button treadmill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);

        treadmill = (Button) findViewById(R.id.treadmill);

        treadmill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Treadmill();
            }
        });

    }
    public void Treadmill(){
        Intent intent = new Intent(this,Treadmill.class);
        startActivity(intent);
    }
}
