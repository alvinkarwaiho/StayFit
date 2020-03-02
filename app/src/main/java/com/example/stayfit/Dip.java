package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
     myRef.setValue("At the edge of a bench, grip the seat next to the hip and fingers making sure that the foot is pointed out. Make sure to extend legs and the feet a width apart with heels pointing towards the ground.");
    myRef1.setValue("Press the palms to lift the body and slide forward enough so that the edge of the chair is behind yourself.");
     myRef2.setValue("Keeping in mind you should lower yourself between 45 degrees towards 90 degrees also ensuring that your elbows are bent.");
     myRef3.setValue("Push yourself slowly back up once back to the position started with and repeat for approximately 10 repetitions and more gradually over several weeks’ time.");
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
