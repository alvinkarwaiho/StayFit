package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dip extends AppCompatActivity {
    TextView information;
    TextView information1;
    TextView information2;
    TextView information3;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("dips1");
    DatabaseReference myRef1 = database.getReference("dips2");
    DatabaseReference myRef2 = database.getReference("dips3");
    DatabaseReference myRef3 = database.getReference("dips4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dip);
        information =(TextView) findViewById(R.id.dips_information);
        information1 =(TextView) findViewById(R.id.dips_information1);
        information2=(TextView) findViewById(R.id.dips_information2);
        information3=(TextView) findViewById(R.id.dips_information3);

    }


}
