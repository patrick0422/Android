package com.example.firebaseuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);

        EditText etUserEmail = findViewById(R.id.etUserEmail);
        EditText etUserPwd = findViewById(R.id.etUserPwd);
        EditText etUserPwdConfirm = findViewById(R.id.etUserPwdConfirm);

        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserEmail = etUserEmail.getText().toString();
                String UserPwd = etUserPwd.getText().toString();
                String UserPwdConfirm = etUserPwdConfirm.getText().toString();

                // 입력 칸 모두 채워지지 않음
                if (UserEmail.equals("") || UserPwd.equals("") || UserPwdConfirm.toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "정보를 모두 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }
                // 비밀번호 일치 X
                else if (!UserPwd.equals(UserPwdConfirm)) {
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
                // 모든 정보 올바름
                else {
                    mAuth.createUserWithEmailAndPassword(UserEmail, UserPwd)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}