package com.example.uas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView log;
    EditText inputEmail, pass1, pass2;
    String email,password1,password2;
    Button btnDaftar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        log = (TextView)findViewById(R.id.sudahAdaAkun);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( RegisterActivity.this, LoginActivity.class));

            }
        });

        inputEmail = findViewById(R.id.email);
        pass1 = findViewById(R.id.password);
        pass2 = findViewById(R.id.password2);
        btnDaftar = findViewById(R.id.buttonDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registrasi();


            }
        });
    }

    private void registrasi() {
        email = inputEmail.getText().toString();
        password1 = pass1.getText().toString();
        password2 = pass2.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText( RegisterActivity.this, "Registrasi Sukses", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText( RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}