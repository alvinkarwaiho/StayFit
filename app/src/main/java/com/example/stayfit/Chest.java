package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Chest extends AppCompatActivity {

    TextView text;
    TextView information;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    DatabaseReference myRef2 = database.getReference("information");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

    text = (TextView)findViewById(R.id.msgTxt);
    information = (TextView) findViewById(R.id.information);

 //   text.setText("Message appearing...");
    myRef.setValue("Chest Press");
    myRef2.setValue("To perform this exercise you lie flat on a bench under the rack , feet should be flat, bar aligned in front of the barbell rack.\n Wrap the bar with your thumb within the outside of your closed fist. Arms slightly wider than shoulder and the arms above should be approximately 45 degrees apart. Lift the barbell up and take a breath and ensuring arms are extended , exhale and push towards slightly above the chest and push up whilst exhaling. To finish you return the bar above the chest and place onto the bench rack.");
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
    }



}
