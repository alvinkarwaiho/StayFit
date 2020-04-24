package com.example.stayfit;

import android.widget.Button;

import androidx.annotation.ContentView;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest extends TestCase {
    MainActivity activity;

   @Test
    public void test(){
       final Button button= activity.findViewById(R.id.cardio1);
        assertTrue(button);
        Expresso
   }

    private void assertTrue(Button button) {
    }

}