package com.example.filmkutuphanesi.view;



import static android.widget.Toast.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class Login extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editTextEmail, editTextPassword;
    private Button buttonRegister;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        mAuth = FirebaseAuth.getInstance();


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kayıt işlemi burada gerçekleştirilecek
                signInUser(editTextEmail.getText().toString().trim(),editTextPassword.getText().toString().trim());
            }
        });

    }


    private void signInUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if (SessionManager.getInstance(getApplicationContext()).login(email, password)){
                                makeText(Login.this, "Giriş başarılı", LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, MoviePage.class);
                                startActivity(intent);

                            }

                        } else {
                            makeText(Login.this, "Giriş başarısız", LENGTH_SHORT).show();
                        }
                    }
                });
    }
}




