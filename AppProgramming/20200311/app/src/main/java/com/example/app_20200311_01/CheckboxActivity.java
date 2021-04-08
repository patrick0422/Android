package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckboxActivity extends AppCompatActivity implements View.OnClickListener {

    TextView choice;
    CheckBox menu1, menu2, menu3, menu4, menu5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        choice = findViewById(R.id.tvChoice);

        menu1 = findViewById(R.id.menuSullung);
        menu2 = findViewById(R.id.menuHead);
        menu3 = findViewById(R.id.menuBlood);
        menu4 = findViewById(R.id.menuKongnamool);
        menu5 = findViewById(R.id.menuSoondae);


        menu1.setOnClickListener(v -> { onMenuChange(); });
        menu2.setOnClickListener(v -> { onMenuChange(); });
        menu3.setOnClickListener(v -> { onMenuChange(); });
        menu4.setOnClickListener(v -> { onMenuChange(); });
        menu5.setOnClickListener(v -> { onMenuChange(); });
    }


    private void onMenuChange() {
        String menuSelected = "";

        if (menu1.isChecked())
            menuSelected += menu1.getText() + "\n";
        if (menu2.isChecked())
            menuSelected += menu2.getText() + "\n";
        if (menu3.isChecked())
            menuSelected += menu3.getText() + "\n";
        if (menu4.isChecked())
            menuSelected += menu4.getText() + "\n";
        if (menu5.isChecked())
            menuSelected += menu5.getText();

        choice.setText(menuSelected);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.menuSullung || id == R.id.menuHead || id == R.id.menuBlood || id == R.id.menuKongnamool || id == R.id.menuSoondae) {
            checkText();
        }
    }
    private void checkText() {
        String checkStr = "";

        if (menu1.isChecked()) {
            checkStr = menu1.getText().toString();
        }
        if (menu2.isChecked()) {
            checkStr += "\n" + menu2.getText().toString();
        }
        if (menu3.isChecked()) {
            checkStr += "\n" + menu3.getText().toString();
        }
        if (menu4.isChecked()) {
            checkStr += "\n" + menu4.getText().toString();
        }
        if (menu5.isChecked()) {
            checkStr += "\n" + menu5.getText().toString();
        }

        choice.setText(checkStr);
    }
}