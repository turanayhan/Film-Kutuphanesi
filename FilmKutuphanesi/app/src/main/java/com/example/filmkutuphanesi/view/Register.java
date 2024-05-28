package com.example.filmkutuphanesi.view;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;
import com.example.filmkutuphanesi.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {


    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword;
    private Button buttonRegister;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();



        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kayıt işlemi burada gerçekleştirilecek
                createUser();
            }
        });
    }

    private void createUser() {
        // Kullanıcı bilgilerini al
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Kullanıcı bilgilerini kontrol et
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Tüm alanları doldurun", Toast.LENGTH_SHORT).show();
            return;
        }
        // Firebase Auth ile kullanıcı kaydetme
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Register.this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                            registerUser();
                        } else {
                            // Kayıt başarısız oldu
                            Toast.makeText(Register.this, "Kayıt başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void registerUser() {
        // Kullanıcı bilgilerini al
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Kullanıcı bilgilerini kontrol et
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Tüm alanları doldurun", Toast.LENGTH_SHORT).show();
            return;
        }

        writeNewUser(firstName,lastName,email,password);
        // Kayıt başarılı mesajı



    }

    private void writeNewUser(String name,String lastname, String email,String password) {
        User user = new User(name,lastname,email);

        mDatabase.child("users").push().setValue(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        SessionManager.getInstance(getApplicationContext()).register(email, password);
                        Toast.makeText(this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Veri başarıyla yazıldı.");
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                    } else {
                        Log.e(TAG, "Veri yazma hatası: ", task.getException());
                    }
                });
    }


    }
