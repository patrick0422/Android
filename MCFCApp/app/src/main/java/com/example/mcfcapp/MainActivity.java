package com.example.mcfcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_MCFCApp);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }
}