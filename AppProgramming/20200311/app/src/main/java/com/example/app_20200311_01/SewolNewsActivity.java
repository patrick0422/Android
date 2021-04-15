package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SewolNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewol_news);

        ImageView iv = findViewById(R.id.iv1);
        iv.setOnClickListener(v->{
            startActivity(new Intent(this, LetterActivity.class));
        });
    }
}