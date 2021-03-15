package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText editText = findViewById(R.id.editText);
        editText.setText(editText.getText() + "에디트텍스트");
        editText.setTextColor(Color.RED);
        editText.setTextSize(40);
    }
}