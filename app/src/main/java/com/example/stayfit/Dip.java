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

public class Dip extends AppCompatActivity {
   private VideoView viewOfVideo;
   private MediaController controller;
   private TextView information;
   private TextView information1;
   private TextView information2;
   private TextView information3;
   private Button warningAlert;
   private TextView warningText;
   private Button alert;
   private TextView textAlert;
   private FirebaseDatabase database = FirebaseDatabase.getInstance();
   private DatabaseReference myRef = database.getReference("dips1");
   private DatabaseReference myRef1 = database.getReference("dips2");
   private DatabaseReference myRef2 = database.getReference("dips3");
   private DatabaseReference myRef3 = database.getReference("dips4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dip);
        dipHome();
        alert = findViewById(R.id.alertdip);
        textAlert = findViewById(R.id.alertokdip);
        warningAlert = findViewById(R.id.warningAlertDip);
        warningText = findViewById(R.id.alertWarningDip);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Dip.this);
                build.setCancelable(true);
                build.setTitle("Did you know?");
                build.setMessage("Dips benefit the triceps and releases the triceps throughout the upper arm well. A sport that requires great action to pull will be useful.");

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
                AlertDialog.Builder build = new AlertDialog.Builder(Dip.this);
                build.setCancelable(true);
                build.setTitle("Warning");
                build.setMessage("To prevent injury make sure to not overtrain and work as much as you are confortable with");

                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        warningText.setVisibility(View.VISIBLE);
                    }
                });
                build.show();
            }
        });

        information  = findViewById(R.id.dips_information);
        information1 = findViewById(R.id.dips_information1);
        information2 = findViewById(R.id.dips_information2);
        information3 = findViewById(R.id.dips_information3);
        viewOfVideo  = findViewById(R.id.videoViewDip);
        controller = new MediaController(this);
        controller.setAnchorView(viewOfVideo);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/stayfit-5a8e7.appspot.com/o/Tricepdips.mp4?alt=media&token=552f340d-7f8c-4b1b-8c41-03c9ade4120a");
        viewOfVideo.setMediaController(controller);
        viewOfVideo.setVideoURI(uri);
        viewOfVideo.start();
//        myRef.setValue("At the edge of a bench, grip the seat next to the hip and fingers making sure that the foot is pointed out. Make sure to extend legs and the feet a width apart with heels pointing towards the ground.");
//        myRef1.setValue("Press the palms to lift the body and slide forward enough so that the edge of the bench is behind you.");
//        myRef2.setValue("Keeping in mind you should lower yourself between 45 degrees towards 90 degrees also ensuring that your elbows are bent.");
//        myRef3.setValue("Push yourself slowly back up once back to the position started with and repeat for approximately 10 repetitions and more gradually over several weeks’ time.");
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

    public void dipHome(){
        Button home = findViewById(R.id.homeDip);
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
