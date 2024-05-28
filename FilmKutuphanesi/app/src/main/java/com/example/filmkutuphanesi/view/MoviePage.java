package com.example.filmkutuphanesi.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmkutuphanesi.Adapter.FilmAdapter;
import com.example.filmkutuphanesi.Builder.FilmBuilder;
import com.example.filmkutuphanesi.R;
import com.example.filmkutuphanesi.model.Film;
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

    private List<Film> getFilmList() {
        // Film nesnelerini oluşturmak için FilmBuilder kullanımı
        Film film1 = new FilmBuilder("Interstellar")
                .yonetmen("Christopher Nolan")
                .oyuncular(Arrays.asList("Matthew McConaughey", "Anne Hathaway"))
                .tur("Bilim Kurgu")
                .cikisYili(2014)
                .sure(169)
                .build();

        Film film2 = new FilmBuilder("Inception")
                .yonetmen("Christopher Nolan")
                .oyuncular(Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"))
                .tur("Bilim Kurgu")
                .cikisYili(2010)
                .sure(148)
                .build();

        // Daha fazla film ekleyebilirsiniz
        return Arrays.asList(film1, film2);
    }
}
