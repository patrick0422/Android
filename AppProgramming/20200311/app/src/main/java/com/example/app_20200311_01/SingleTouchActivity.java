package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SingleTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SingleTouchView(this, null));
    }
}