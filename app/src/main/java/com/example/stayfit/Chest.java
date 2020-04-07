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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Chest extends AppCompatActivity {

  private VideoView viewOfVideo;
  private MediaController controller;
  private Button alert;
  private TextView textAlert;
  private  TextView text;
  private  TextView information;
  private  TextView information1;
  private  TextView information2;
  private  TextView information3;
  private  TextView information4;
  private  FirebaseDatabase database = FirebaseDatabase.getInstance();
  private  DatabaseReference myRef = database.getReference("message");
  private  DatabaseReference myRef2 = database.getReference("Step1");
  private  DatabaseReference myRef3 = database.getReference("Step2");
  private  DatabaseReference myRef4 = database.getReference("Step3");
  private  DatabaseReference myRef5 = database.getReference("Step4");
  private  DatabaseReference myRef6 = database.getReference("Step5");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
        chestHome();
        alert = findViewById(R.id.alertchest);
        textAlert = findViewById(R.id.alertokchest);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder build = new AlertDialog.Builder(Chest.this);
                build.setCancelable(true);
                build.setTitle("Did you know?");
                build.setMessage("Muscles that benefit from this exercise are as follows: Chest, triceps and shoulders. Used mainly in day to day life to push or lift up objects.");

                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textAlert.setVisibility(View.VISIBLE);
                    }
                });
                build.show();
            }
        });
    viewOfVideo = findViewById(R.id.videoViewChest);
    controller = new MediaController(this);
    controller.setAnchorView(viewOfVideo);
    Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/stayfit-5a8e7.appspot.com/o/bench%20press.mp4?alt=media&token=ac747fd2-6467-49e8-b7c8-9fecfcec434e");
    viewOfVideo.setMediaController(controller);
    viewOfVideo.setVideoURI(uri);
    viewOfVideo.start();
    text =         findViewById(R.id.msgTxt);
    information =  findViewById(R.id.information);
    information1 = findViewById(R.id.information1);
    information2 = findViewById(R.id.information2);
    information3 = findViewById(R.id.information3);
    information4 = findViewById(R.id.information4);

//        myRef.setValue("Chest Press");
//  myRef2.setValue("Lie flat under the bar.Eyes should be placed within the front of the barbell rack");
//  myRef3.setValue("Keeping feet relatively wide apart and flat on the floor");
//  myRef4.setValue("Hold the bar firmly and outside using a closed fist and ensuring that the shoulder is a shoulder width apart from the grop and that the arms is 45 degrees apart from the body.");
//  myRef5.setValue("Ensure that you take a deep breath and lift the bar above the chest with arms extended, and as you push upwards exhale.Not only this ensure you keep focus on the ceiling than the bar to prevent injury.");
//  myRef6.setValue("Once exercise is done return the bar towards the rack and repeat this exercise for 5 sets and 5 repetitions to achieve strength.");
    myRef2.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String value2 = dataSnapshot.getValue(String.class);
           information.setText(value2);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    myRef.addValueEventListener(new ValueEventListener() {

        @Override
        public void onDataChange( DataSnapshot dataSnapshot) {
            String value = dataSnapshot.getValue(String.class);
            text.setText(value);

        }

        @Override
        public void onCancelled( DatabaseError databaseError) {

        }
    });
    myRef3.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String value = dataSnapshot.getValue(String.class);
        information1.setText(value);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    myRef4.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String value = dataSnapshot.getValue(String.class);
            information2.setText(value);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    myRef5.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String value = dataSnapshot.getValue(String.class);
            information3.setText(value);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    myRef6.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String value = dataSnapshot.getValue(String.class);
            information4.setText(value);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }

    public void chestHome(){
        Button home = findViewById(R.id.homeChest);
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
