package com.example.filmkutuphanesi.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;
import com.example.filmkutuphanesi.model.Film;

import java.util.Arrays;

public class MoviePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        deneme();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            // Çıkış yapma işlemleri burada gerçekleşecek
            Toast.makeText(this, "Çıkış Yapıldı", Toast.LENGTH_SHORT).show();
            SessionManager.getInstance(getApplicationContext()).logout();
            Intent intent = new Intent(MoviePage.this, SplashScreen.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deneme(){



        // Film nesnesini oluşturmak için FilmBuilder kullanımı
        Film film = Film.builder("Interstellar")
                .yonetmen("Christopher Nolan")
                .oyuncular(Arrays.asList("mahsun", "oyuncu2"))
                .tur("Bilim Kurgu")
                .cikisYili(2014)
                .sure(169)
                .build();

        Log.d("FilmBilgileri", "Film Adı: " + film.getAd());
        Log.d("FilmBilgileri", "Yönetmen: " + film.getYonetmen());
        Log.d("FilmBilgileri", "Oyuncular:");
        for (String oyuncu : film.getOyuncular()) {
            Log.d("FilmBilgileri", "- " + oyuncu);
        }
        Log.d("FilmBilgileri", "Tür: " + film.getTur());
        Log.d("FilmBilgileri", "Çıkış Yılı: " + film.getCikisYili());
        Log.d("FilmBilgileri", "Süre: " + film.getSure() + " dakika");

        Toast.makeText(this, "Kayıt başarılı"+film.getAd(), Toast.LENGTH_LONG).show();


    }

    }


