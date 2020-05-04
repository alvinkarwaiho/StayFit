package com.example.stayfit;

import android.content.IntentFilter;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class test {

    /* Used to test calorie counter addition of calories logic*/
    @Test
    public void testingCalorieCounterLogic() {

        int one = 400;
        int two = 600;
        int three = 200;
        int four = 200;
        int fifth = 300;
        int sixth = 150;
        int seventh = 50;
        int eight = 50;
        int ninth = 50;
        int total = one + two + three + four + fifth + sixth + seventh + eight + ninth;
        int total2 = 2000;
        Assert.assertEquals(total2, total);
    }
    /* Used to test that the size of step counter calculates the accerators and the value is not null*/
    @Test
    public void TestingStepCounterSizeIsNotEmpty() {
        float accelerate_x;
        float accelerate_y;
        float accelerate_z;
        double previousMag = 0;
        double size;
        double sizeDelta;
        accelerate_x = 1;
        accelerate_y = 2;
        accelerate_z = 3;

        size = Math.sqrt(accelerate_x * accelerate_x + accelerate_y * accelerate_y + accelerate_z * accelerate_z);
        sizeDelta = size - previousMag;
        Assert.assertNotNull(sizeDelta);
    }
    /* Used to test that the counter that counts steps is not empty.*/
    @Test
    public void StepCounterIsNotEmpty(){
        Integer count =0;
        float accelerate_x;
        float accelerate_y;
        float accelerate_z;
        double previousMag = 0;
        double size;
        double sizeDelta;
        accelerate_x = 1;
        accelerate_y = 2;
        accelerate_z = 3;

        size = Math.sqrt(accelerate_x * accelerate_x + accelerate_y * accelerate_y + accelerate_z * accelerate_z);
        sizeDelta = size - previousMag;
        Assert.assertNotNull(sizeDelta);
        if (sizeDelta >6){
            count++;
        }
        Assert.assertNotNull(count);
    }
    /*Step counter testing if the magnitude is empty or not.*/
    @Test
    public void StepCounterIsMagnitudeNotEmpty(){
        Integer count =0;
        float accelerate_x;
        float accelerate_y;
        float accelerate_z;
        double previousMag = 0;
        double size;
        double sizeDelta;
        accelerate_x = 1;
        accelerate_y = 2;
        accelerate_z = 3;

        size = Math.sqrt(accelerate_x * accelerate_x + accelerate_y * accelerate_y + accelerate_z * accelerate_z);
        sizeDelta = size - previousMag;

        Assert.assertNotNull(previousMag);
    }



}
