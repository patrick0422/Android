package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckboxActivity extends AppCompatActivity {

    CheckBox menu1, menu2, menu3, menu4, menu5;

    TextView choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        menu1 = findViewById(R.id.menuSulung);
        menu2 = findViewById(R.id.menuHead);
        menu3 = findViewById(R.id.menuBlood);
        menu4 = findViewById(R.id.menuKongnamool);
        menu5 = findViewById(R.id.menuSoondae);

        choice = findViewById(R.id.tvChoice);

        menu1.setOnClickListener(v -> {  });
        menu2.setOnClickListener(v -> {  });
        menu3.setOnClickListener(v -> {  });
        menu4.setOnClickListener(v -> {  });
        menu5.setOnClickListener(v -> {  });
    }
}