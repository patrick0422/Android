package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SomaTalkActivity extends AppCompatActivity {
    EditText userId;
    EditText userPwd;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soma_talk);

        userId = findViewById(R.id.userId);
        userPwd = findViewById(R.id.userPwd);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            checkLogin();
        });
    }
    private void checkLogin() {
        String id = userId.getText().toString();
        String pwd = userPwd.getText().toString();
        
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "아이디와 패스워드를 모두 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (id.equals("admin") && pwd.equals("1234"))
            startActivity(new Intent(this, LoginSucceedActivity.class));
        else
            Toast.makeText(this, "아이디와 패스워드가 올바르지 않습니다", Toast.LENGTH_SHORT).show();
    }
}