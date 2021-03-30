package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {
    int[] imgName = {
            R.drawable.mudo1, R.drawable.mudo2, R.drawable.mudo3, R.drawable.mudo4, R.drawable.mudo5
    };
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageView iv = findViewById(R.id.iv1);

        Button btnPrev = findViewById(R.id.btnPrev);
        Button btnNext = findViewById(R.id.btnNext);

        btnPrev.setOnClickListener(v -> {
            if (index >= imgName.length - 1)
                index = 0;
            else
                index++;

            iv.setImageResource(imgName[index]);
        });

        btnNext.setOnClickListener(v -> {
            if (index <= 0)
                index = imgName.length - 1;
            else
                index--;

            iv.setImageResource(imgName[index]);
        });
    }
}