package com.example.firebaseuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SuccessActivity extends AppCompatActivity {
    FirebaseAuth mAuth;

    TextView tvUserId, tvUserText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        mAuth = FirebaseAuth.getInstance();

        tvUserId = findViewById(R.id.tvUserId);
        tvUserText = findViewById(R.id.tvUserText);

        initUserInfo();


        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(SuccessActivity.this, "로그아웃되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    private void initUserInfo() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            Toast.makeText(getApplicationContext(), "로그인되어있지 않습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            tvUserId.setText(user.getEmail());
        }
    }
}