package com.example.filmkutuphanesi.view;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.appcompat.app.AppCompatActivity;

import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;

public class SplashScreen extends AppCompatActivity {

    private SessionManager loginManager;

    // Geçiş süresi (3 saniye)
    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loginManager = SessionManager.getInstance(this);



        // 3 saniye sonra ana aktiviteye geçiş yap
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Ana aktiviteye geçiş yap

                // Kullanıcı oturum açmış mı kontrol et
                if (loginManager.isLoggedIn()) {
                    Intent intent = new Intent(SplashScreen.this, MoviePage.class);
                    startActivity(intent);
                    finish();

                } else {
                    // Kullanıcı oturum açmamışsa, giriş ekranına yönlendir

                    Intent intent = new Intent(SplashScreen.this, SecondScreen.class);
                    startActivity(intent);
                    finish(); // Bu aktiviteyi kapat
                }


            }
        }, SPLASH_TIME_OUT);
    }
}
