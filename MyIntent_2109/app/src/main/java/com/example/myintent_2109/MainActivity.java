package com.example.myintent_2109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv1, iv2, iv3, iv4, iv5;

        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
        iv5 = findViewById(R.id.iv5);

        iv2.setOnClickListener(v -> { startActivity(new Intent(this, SubActivity1.class)); });
        iv3.setOnClickListener(v -> { startActivity(new Intent(this, SubActivity2.class)); });
        iv4.setOnClickListener(v -> { startActivity(new Intent(this, SubActivity3.class)); });
        iv5.setOnClickListener(v -> { startActivity(new Intent(this, SubActivity4.class)); });
    }
}