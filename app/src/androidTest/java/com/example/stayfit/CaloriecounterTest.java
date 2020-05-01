package com.example.stayfit;

import android.text.TextUtils;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaloriecounterTest extends TestCase {
    Caloriecounter activity=null;
    ActivityTestRule<Caloriecounter> caloriecounterActivityTestRule = new ActivityTestRule<Caloriecounter>(Caloriecounter.class);
    @Before
    public void setUp() throws Exception {
        activity = caloriecounterActivityTestRule.getActivity();
    }
    @Test
    public void test(){

    }

    @After
    public void tearDown() throws Exception {

    }
}