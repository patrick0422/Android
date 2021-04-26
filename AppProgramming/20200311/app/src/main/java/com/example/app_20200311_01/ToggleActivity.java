package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ToggleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        ImageView iv1 = findViewById(R.id.iv1);
        ToggleButton btn = findViewById(R.id.btn1);
        btn.setOnCheckedChangeListener((v, b) -> {
            if (b)
                iv1.setImageResource(R.drawable.gugu_down);
            else
                iv1.setImageResource(R.drawable.gugu_up);
        });
    }
}