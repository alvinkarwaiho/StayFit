package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Caloriecounter extends AppCompatActivity {
   private EditText firstNumber;
   private EditText secondNumber;
   private EditText thirdNumber;
   private EditText fourthNumber;
   private EditText fifthNumber;
   private EditText sixthNumber;
   private EditText seventhNumber;
   private EditText eighthNumber;
   private EditText ninthNumber;
   private TextView text;
   private Button calculate;
   private int one=0;
   private int two=0;
   private int three=0;
   private int four=0;
   private int fifth=0;
   private int sixth=0;
   private int seventh=0;
   private int eighth=0;
   private int ninth=0;
   private int total=0;
   private TextView averageMC;
   private TextView averageFC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caloriecounter);
        calorieHome();
        firstNumber = findViewById(R.id.editcalorie1);
        secondNumber= findViewById(R.id.editcalorie2);
        thirdNumber = findViewById(R.id.editcalorie3);
        fourthNumber = findViewById(R.id.editcalorie4);
        fifthNumber = findViewById(R.id.editcalorie5);
        sixthNumber = findViewById(R.id.editcalorie6);
        seventhNumber = findViewById(R.id.editcalorie7);
        eighthNumber = findViewById(R.id.editcalorie8);
        ninthNumber = findViewById(R.id.editcalorie9);
        averageMC = findViewById(R.id.averageMC);
        averageFC = findViewById(R.id.averageFC);
        calculate = findViewById(R.id.calculate);
        text = findViewById(R.id.totalcalorie);


        firstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber.setText("");
            }
        });
        secondNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondNumber.setText("");
            }
        });
        thirdNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdNumber.setText("");
            }
        });
        fourthNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourthNumber.setText("");
            }
        });
        fifthNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fifthNumber.setText("");
            }
        });
        sixthNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sixthNumber.setText("");
            }
        });
        seventhNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seventhNumber.setText("");
            }
        });
        eighthNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eighthNumber.setText("");
            }
        });
        ninthNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ninthNumber.setText("");
            }
        });
                calculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        one = Integer.parseInt(firstNumber.getText().toString());
                        two = Integer.parseInt(secondNumber.getText().toString());
                        three = Integer.parseInt(thirdNumber.getText().toString());
                        four = Integer.parseInt(fourthNumber.getText().toString());
                        fifth = Integer.parseInt(fifthNumber.getText().toString());
                        sixth = Integer.parseInt(sixthNumber.getText().toString());
                        seventh = Integer.parseInt(seventhNumber.getText().toString());
                        eighth = Integer.parseInt(eighthNumber.getText().toString());
                        ninth = Integer.parseInt(ninthNumber.getText().toString());
                        total = one + two + three + four + fifth + sixth + seventh + eighth + ninth;
                        if (total >= 2500) {
                            averageMC.setText("You reach the daily male average intake of approximately 2500 kcal");
                        } else {
                            averageMC.setText("You are below the daily male average intake of 2500 kcal");
                        }
                        if (total >= 2000) {
                            averageFC.setText("You reach the daily female average intake of approximately 2000 kcal");
                        } else {
                            averageFC.setText("You are below the daily female average intake of approximately 2000 kcal");
                        }
                        text.setText("" + String.valueOf(total));
                    }
                });

    }
    public void calorieHome(){
        Button home = findViewById(R.id.homeCalorie);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePage();
            }
        });

    }
    public void homePage(){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }


}
