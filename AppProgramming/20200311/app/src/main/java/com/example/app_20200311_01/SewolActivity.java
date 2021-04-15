package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SewolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewol);

        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(v->{
            startActivity(new Intent(this, SewolNewsActivity.class));
        });
    }
}