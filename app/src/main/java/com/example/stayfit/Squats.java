package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Squats extends AppCompatActivity {
    private TextView information;
    private TextView information1;
    private TextView information2;
    private TextView information3;
    private TextView information4;
    private TextView information5;
    private Button warningAlert;
    private TextView warningText;
    private Button alert;
    private TextView textAlert;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference( "Squats_1");
    private DatabaseReference myRef1 = database.getReference("Squats_2");
    private DatabaseReference myRef2= database.getReference( "Squats_3");
    private DatabaseReference myRef3 = database.getReference("Squats_4");
    private DatabaseReference myRef4 = database.getReference("Squats_5");
    private DatabaseReference myRef5 = database.getReference("Squats_6");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squats);
        squatHome();
        alert = findViewById(R.id.alertsquats);
        textAlert = findViewById(R.id.alertoksquats);
        warningAlert = findViewById(R.id.warningAlertSquats);
        warningText = findViewById(R.id.alertWarningSquats);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Squats.this);
                build.setCancelable(true);
                build.setTitle("Did you know?");
                build.setMessage("Squat trains the lower body. Squats benefit the strength , such as power and endurance. Also, benefits the strength of the upper body.");

                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textAlert.setVisibility(View.VISIBLE);
                    }
                });
                build.show();
            }
        });
        warningAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Squats.this);
                build.setCancelable(true);
                build.setTitle("Warning");
                build.setMessage("Beginners make sure you start with the bar , lifting weights safely with someone behind the bar and gradually increase the weight over time.");

                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        warningText.setVisibility(View.VISIBLE);
                    }
                });
                build.show();
            }
        });
        information = (TextView) findViewById(R.id.squats_information);
        information1 = (TextView) findViewById(R.id.squats_information1);
        information2 = (TextView) findViewById(R.id.squats_information2);
        information3 = (TextView) findViewById(R.id.squats_information3);
        information4 = (TextView) findViewById(R.id.squats_information4);
        information5 = (TextView) findViewById(R.id.squats_information5);

//        myRef.setValue("Maintain a wide stance and place your feet a shoulder width apart under the bar, making sure that you do not use the heels or toes.");
//        myRef1.setValue("Bend the knees slowly, and making sure that you look right forward, ensure that you do not lean forward at any time to prevent injury. ");
//        myRef2.setValue("Always make sure that you maintain a slow and controlled muscle tension and inhale when lower.");
//        myRef3.setValue("Return slowly towards the starting position and back and hip below the bar. Exhale as you return to the standing position.");
//        myRef4.setValue("Repeat 3 sets of 6 to 10 squats");
//        myRef5.setValue("Once exercise finished place the bar carefully back to the rack with the bar still on you double check left and right the bar is back on the rack.");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                information.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                information1.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                information2.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                information3.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                information4.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                information5.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    public void squatHome(){
        Button home = findViewById(R.id.homeSquats);
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
