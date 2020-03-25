package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
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
  private  TextView information;
  private  TextView information1;
  private  TextView information2;
  private  TextView information3;
  private  FirebaseDatabase database = FirebaseDatabase.getInstance();
  private  DatabaseReference myRef = database.getReference( "curl_1");
  private  DatabaseReference myRef1 = database.getReference("curl_2");
  private  DatabaseReference myRef2= database.getReference( "curl_3");
  private  DatabaseReference myRef3 = database.getReference("curl_4");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicepcurl);
        viewOfVideo = findViewById(R.id.videoViewCurl);
        MediaController controller = new MediaController(this);
        controller.setAnchorView(viewOfVideo);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/stayfit-5a8e7.appspot.com/o/Bicepcurls.mp4?alt=media&token=4abf9ad5-09c5-4e2b-bda3-e0bd37cb1617");
        viewOfVideo.setMediaController(controller);
        viewOfVideo.setVideoURI(uri);
        viewOfVideo.start();

        information = (TextView) findViewById(R.id.curl_information);
        information1 = (TextView) findViewById(R.id.curl_information1);
        information2 = (TextView) findViewById(R.id.curl_information2);
        information3 = (TextView) findViewById(R.id.curl_information3);

//        myRef.setValue("Hold and stand upright holding a dumbbell with each hand wrapped around each dumbbell with arms hanging by the side.");
//        myRef1.setValue("Make sure that your palms and elbow are facing forward. ");
//        myRef2.setValue("Exhale as you curl the weights up to the shoulder level whilst also contracting the biceps");
//        myRef3.setValue("Repeat this movement for 2 sets of 12 reps.");
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
}
