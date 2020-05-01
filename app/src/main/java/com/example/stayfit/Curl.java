package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Curl extends AppCompatActivity {

  private  VideoView viewOfVideo;
  private Button alert;
  private TextView textAlert;
  private  TextView information;
  private  TextView information1;
  private  TextView information2;
  private  TextView information3;
  private Button warningAlert;

  private TextView warningText;
  private MediaController controller;
  private  FirebaseDatabase database = FirebaseDatabase.getInstance();
  private  DatabaseReference myRef = database.getReference( "curl_1");
  private  DatabaseReference myRef1 = database.getReference("curl_2");
  private  DatabaseReference myRef2= database.getReference( "curl_3");
  private  DatabaseReference myRef3 = database.getReference("curl_4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicepcurl);
        curlHome();
        alert= findViewById(R.id.alertcurl);
        textAlert = findViewById(R.id.alertokcurl);
        warningAlert = findViewById(R.id.warningAlertCurl);
        warningText = findViewById(R.id.alertWarningCurl);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Curl.this);
                build.setCancelable(true);
                build.setTitle("Did you know?");
                build.setMessage("Bicep works the upper arm and muscles are used mostly in daily life to pick objects up.");

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
                AlertDialog.Builder build = new AlertDialog.Builder(Curl.this);
                build.setCancelable(true);
                build.setTitle("Warning");
                build.setMessage("To prevent injury make sure to gradually build your way up to a confortable weight");

                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        warningText.setVisibility(View.VISIBLE);
                    }
                });
                build.show();
            }
        });

        viewOfVideo = findViewById(R.id.videoViewCurl);
        controller = new MediaController(this);
        controller.setAnchorView(viewOfVideo);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/stayfit-5a8e7.appspot.com/o/Bicepcurls.mp4?alt=media&token=4abf9ad5-09c5-4e2b-bda3-e0bd37cb1617");
        viewOfVideo.setMediaController(controller);
        viewOfVideo.setVideoURI(uri);
        viewOfVideo.start();

        information  = findViewById(R.id.curl_information);
        information1 = findViewById(R.id.curl_information1);
        information2 = findViewById(R.id.curl_information2);
        information3 = findViewById(R.id.curl_information3);

//        myRef.setValue("Hold and stand upright holding a dumbbell with each hand wrapped around each dumbbell with arms hanging by the side.");
//        myRef1.setValue("Make sure that your palms and elbows are facing forward. ");
//        myRef2.setValue("Exhale as you curl the weights up to the shoulder level whilst also contracting the biceps.");
//        myRef3.setValue("Repeat this exercise for 2 sets of 12 reps.");
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
    }
    public void curlHome(){
        Button home = findViewById(R.id.homeBicepCurl);
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
