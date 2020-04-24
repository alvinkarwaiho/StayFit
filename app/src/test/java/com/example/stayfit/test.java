package com.example.stayfit;

import android.app.Activity;
import android.widget.EditText;

import androidx.annotation.ContentView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;

import static java.lang.String.valueOf;

public class test implements TestRule {

    Caloriecounter caloriecounter = new Caloriecounter();
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);
    @Test
    public void test(){
    EditText edit = caloriecounter.findViewById(R.id.cardio1);

    }    @Override
    public Statement apply(Statement base, Description description) {
        return null;
    }
}
