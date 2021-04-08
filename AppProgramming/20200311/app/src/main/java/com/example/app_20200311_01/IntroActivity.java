package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        TextView run1 = findViewById(R.id.run1);
        TextView run2 = findViewById(R.id.run2);

        run1.setOnClickListener(v -> {
            startActivity(new Intent(this, IntroSwActivity.class));
        });
        run2.setOnClickListener(v -> {
            startActivity(new Intent(this, IntroEmbededActivity.class));
        });
    }
}