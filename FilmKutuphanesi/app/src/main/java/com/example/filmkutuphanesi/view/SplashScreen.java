package com.example.filmkutuphanesi.view;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.appcompat.app.AppCompatActivity;

import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;

public class SplashScreen extends AppCompatActivity {

    private SessionManager loginManager;

    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loginManager = SessionManager.getInstance(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (loginManager.isLoggedIn()) {
                    Intent intent = new Intent(SplashScreen.this, MoviePage.class);
                    startActivity(intent);
                    finish();

                } else {

                    Intent intent = new Intent(SplashScreen.this, SecondScreen.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_TIME_OUT);
    }
}
