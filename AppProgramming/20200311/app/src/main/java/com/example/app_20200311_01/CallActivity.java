package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        TextView tv =  findViewById(R.id.tvNum);
        Button btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(v -> {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1);
//            else
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + tv.getText())));
        });
    }
}