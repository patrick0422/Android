package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

//        add.setOnClickListener(v -> addClick(v));
//        sub.setOnClickListener(v -> subClick(v));
//        mul.setOnClickListener(v -> mulClick(v));
//        div.setOnClickListener(v -> divClick(v));

        add.setOnClickListener(v -> Calc("+"));
        sub.setOnClickListener(v -> Calc("-"));
        mul.setOnClickListener(v -> Calc("*"));
        div.setOnClickListener(v -> Calc("/"));
    }

    public void addClick(View v) {
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

        TextView result = findViewById(R.id.result);

        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());

        result.setText(Integer.toString(n1 + n2));
    }
    public void subClick(View v) {
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

        TextView result = findViewById(R.id.result);

        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());

        result.setText(Integer.toString(n1 - n2));
    }
    public void mulClick(View v) {
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

        TextView result = findViewById(R.id.result);

        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());

        result.setText(Integer.toString(n1 * n2));
    }
    public void divClick(View v) {
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

        TextView result = findViewById(R.id.result);

        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());

        result.setText(Integer.toString(n1 / n2));
    }

    public void Calc(String op) {
        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);

        TextView result = findViewById(R.id.result);

        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());

        switch(op){
            case "+":
                result.setText(Integer.toString(n1 + n2));
                break;
            case "-":
                result.setText(Integer.toString(n1 - n2));
                break;
            case "*":
                result.setText(Integer.toString(n1 * n2));
                break;
            case "/":
                result.setText(Integer.toString(n1 / n2));
                break;
        }
    }
}