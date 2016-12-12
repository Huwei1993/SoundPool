package com.example.farhan.applicationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
     demoApplicationClass sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = (demoApplicationClass) getApplication();
    }
    public void sound(View view){
        sound.gPlaySound();
    }
    public void stop(View view){
        sound.gStop();
    }
}
