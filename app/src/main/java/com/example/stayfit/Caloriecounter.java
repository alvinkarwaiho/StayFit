package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

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
   private int one;
   private int two;
   private int three;
   private int four;
   private int fifth;
   private int sixth;
   private int seventh;
   private int eighth;
   private int ninth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caloriecounter);

        firstNumber = findViewById(R.id.editcalorie1);
        secondNumber= findViewById(R.id.editcalorie2);
        thirdNumber = findViewById(R.id.editcalorie3);
        fourthNumber = findViewById(R.id.editcalorie4);
        fifthNumber = findViewById(R.id.editcalorie5);
        sixthNumber = findViewById(R.id.editcalorie6);
        seventhNumber = findViewById(R.id.editcalorie7);
        eighthNumber = findViewById(R.id.editcalorie8);
        ninthNumber = findViewById(R.id.editcalorie9);

        calculate = findViewById(R.id.calculate);
        text = findViewById(R.id.totalcalorie);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one     = Integer.parseInt(firstNumber.getText().toString());
                two     = Integer.parseInt(secondNumber.getText().toString());
                three   = Integer.parseInt(thirdNumber.getText().toString());
                four    = Integer.parseInt(fourthNumber.getText().toString());
                fifth   = Integer.parseInt(fifthNumber.getText().toString());
                sixth   = Integer.parseInt(sixthNumber.getText().toString());
                seventh = Integer.parseInt(seventhNumber.getText().toString());
                eighth  =Integer.parseInt(eighthNumber.getText().toString());
                ninth   = Integer.parseInt(ninthNumber.getText().toString());
                int total   = one + two + three + four + fifth + sixth + seventh + eighth +ninth;
                text.setText(""+ String.valueOf(total));
            }
        });
    }
}
