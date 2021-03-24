package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv3 = findViewById(R.id.tv3);

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012341234"));

                tv3.setText(tv3.getText() + " 문자 추가");
                tv3.setTextColor(Color.RED);
                tv3.setTextSize(50);

                startActivity(intent);
            }
        });

        startActivity(new Intent(this, MainActivity8.class));
    }
}