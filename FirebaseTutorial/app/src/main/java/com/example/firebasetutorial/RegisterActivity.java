package com.example.firebasetutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class RegisterActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        EditText edtUserId = findViewById(R.id.edtUserId);
        EditText edtUserPwd = findViewById(R.id.edtUserPwd);
        EditText edtUserPwdConfirm = findViewById(R.id.edtUserPwdConfirm);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUserId.getText().toString().equals("") || edtUserPwd.getText().toString().equals("") || edtUserPwdConfirm.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "입력란을 모두 채워주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!(edtUserPwd.getText().toString().equals(edtUserPwdConfirm.getText().toString()))) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                

                User user = new User(edtUserId.getText().toString(), edtUserPwd.getText().toString());

                Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();
                writeNewUser("1", edtUserId.getText().toString(), edtUserPwd.getText().toString());
            }
        });

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void writeNewUser(String userId, String name, String password) {
        User user = new User(name, password);

        mDatabase.child("users").child(userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        Toast.makeText(RegisterActivity.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(RegisterActivity.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
