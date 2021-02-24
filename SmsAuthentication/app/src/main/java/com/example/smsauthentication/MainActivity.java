package com.example.smsauthentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.InputFilter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int codeLength = 4;

    EditText edtAuthCode;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAuthCode = findViewById(R.id.edtAuthCode);

        edtAuthCode.setFilters(new InputFilter[] { new InputFilter.LengthFilter(codeLength) });

        btnSubmit = findViewById(R.id.btnSubmit);

        reqPerms();

//        Intent intent = getIntent();
//        processCommand(intent);
    }

    private void reqPerms() {
        String[] permissions = {Manifest.permission.RECEIVE_SMS};
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if(permissionCheck == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, permissions, 1);
        }
    }
    private void processCommand(Intent intent) {
        if (intent != null) {
            String authCode = intent.getStringExtra("authCode");

            Toast.makeText(getApplicationContext(), "인증번호 확인: " + authCode, Toast.LENGTH_SHORT).show();
            edtAuthCode.setText(authCode);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processCommand(intent);
    }
}