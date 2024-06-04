package com.example.filmkutuphanesi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmkutuphanesi.Adapter.FilmAdapter;
import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;
import com.example.filmkutuphanesi.model.Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviePage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FilmAdapter filmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Film> filmList = getFilmList();
        filmAdapter = new FilmAdapter(filmList);
        recyclerView.setAdapter(filmAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            SessionManager.getInstance(getApplicationContext()).logout();
            Intent intent = new Intent(MoviePage.this, SplashScreen.class);
            startActivity(intent); // Exit the activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private List<Film> getFilmList() {


        List<Film> filmList = new ArrayList<>();



// 1. Film
        List<String> oyuncular1 = new ArrayList<>();
        oyuncular1.add("Brad Pitt");
        oyuncular1.add("Leonardo DiCaprio");
        Film film1 = new Film("Once Upon a Time in Hollywood", "Quentin Tarantino", oyuncular1, "Drama", 2019, 161);
        filmList.add(film1);

// 2. Film
        List<String> oyuncular2 = new ArrayList<>();
        oyuncular2.add("Tom Hanks");
        oyuncular2.add("Robin Wright");
        Film film2 = new Film("Forrest Gump", "Robert Zemeckis", oyuncular2, "Drama", 1994, 142);
        filmList.add(film2);

// 3. Film
        List<String> oyuncular3 = new ArrayList<>();
        oyuncular3.add("Heath Ledger");
        oyuncular3.add("Christian Bale");
        Film film3 = new Film("The Dark Knight", "Christopher Nolan", oyuncular3, "Action", 2008, 152);
        filmList.add(film3);

// 4. Film
        List<String> oyuncular4 = new ArrayList<>();
        oyuncular4.add("Anthony Hopkins");
        oyuncular4.add("Jodie Foster");
        Film film4 = new Film("The Silence of the Lambs", "Jonathan Demme", oyuncular4, "Thriller", 1991, 118);
        filmList.add(film4);

// 5. Film
        List<String> oyuncular5 = new ArrayList<>();
        oyuncular5.add("Marlon Brando");
        oyuncular5.add("Al Pacino");
        Film film5 = new Film("The Godfather", "Francis Ford Coppola", oyuncular5, "Crime", 1972, 175);
        filmList.add(film5);




        // Daha fazla film ekleyebilirsiniz
        return Arrays.asList(film1,film2,film3,film4,film5);
    }
}
