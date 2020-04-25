package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URI;

public class Treadmill extends AppCompatActivity {
 private  VideoView viewOfVideo;
 private  MediaController controller;
 private  TextView treadmillInfoOne;
 private  TextView treadmillInfoTwo;
 private  TextView treadmillInfoThree;
 private  TextView treadmillInfoFour;
 private  TextView treadmillInfoFive;
 private Button alert;
 private Button warningAlert;
 private TextView warningText;
 private TextView textAlert;
 private  FirebaseDatabase  database = FirebaseDatabase.getInstance();
 private  DatabaseReference treadmillone  =  database.getReference( "Treadmill_1");
 private  DatabaseReference treadmilltwo  =  database.getReference( "Treadmill_2");
 private  DatabaseReference treadmillthree= database.getReference( "Treadmill_3");
 private  DatabaseReference treadmillfour =  database.getReference( "Treadmill_4");
 private  DatabaseReference treadmillfive = database.getReference( "Treadmill_5");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treadmill);
        treadmillHome();
        alert = findViewById(R.id.alert);
        textAlert = findViewById(R.id.alertok);
        warningAlert = findViewById(R.id.warningAlertTreadmill);
        warningText = findViewById(R.id.alertWarning);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Treadmill.this);
                build.setCancelable(true);
                build.setTitle("Did you know?");
                build.setMessage("Running in general can reduce the risk of many long term illnesses ,for example, type 2 diabetes, strokes and heart diseases.");

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
                AlertDialog.Builder build = new AlertDialog.Builder(Treadmill.this);
                build.setCancelable(true);
                build.setTitle("Warning");
                build.setMessage("Make sure to pace yourself and don't overtrain to prevent injury.");

                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        warningText.setVisibility(View.VISIBLE);
                    }
                });
                build.show();
            }
        });
        viewOfVideo = findViewById(R.id.videoViewTreadmill);
        controller = new MediaController(this);
        controller.setAnchorView(viewOfVideo);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/stayfit-5a8e7.appspot.com/o/treadmill.mp4?alt=media&token=a6e7e5dc-0497-458e-84f9-1d8656d402f4");
        viewOfVideo.setMediaController(controller);
        viewOfVideo.setVideoURI(uri);
        viewOfVideo.start();
        treadmillInfoOne   = findViewById(R.id.treadmill_information);
        treadmillInfoTwo   = findViewById(R.id.treadmill_information1);
        treadmillInfoThree = findViewById(R.id.treadmill_information2);
        treadmillInfoFour  = findViewById(R.id.treadmill_information3);
        treadmillInfoFive  = findViewById(R.id.treadmill_information4);
//         treadmillone.setValue("Warm Up first, by lightly walking on the treadmill for approximately 5 mins.");
//        treadmilltwo.setValue("Have a learn about the different functions within the machine. Whether that’s the heart rate monitor, calorie burn calculator or speed that you are running at.");
//        treadmillthree.setValue("To make it look like you are running outdoors more set the treadmill on a incline and try increasing the speed to challenge yourself.");
//        treadmillfour.setValue("Make sure you don’t hold onto the handrail and make sure posture straight as well as not leaning forward to prevent injury.");
//        treadmillfive.setValue("Once finished gradually decrease the speed down and slowly warm down.");

        treadmillone.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           String value = dataSnapshot.getValue(String.class);
           treadmillInfoOne.setText(value);
       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
      });
       treadmilltwo.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           String value = dataSnapshot.getValue(String.class);
           treadmillInfoTwo.setText(value);
       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
        });
       treadmillthree.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           String value = dataSnapshot.getValue(String.class);
          treadmillInfoThree.setText(value);
       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
   });
     treadmillfour.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           String value = dataSnapshot.getValue(String.class);
           treadmillInfoFour.setText(value);
       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
   });
     treadmillfive.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           String value = dataSnapshot.getValue(String.class);
           treadmillInfoFive.setText(value);
       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
   });



    }
    public void treadmillHome(){
        Button home = findViewById(R.id.homeTreadmill);
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
