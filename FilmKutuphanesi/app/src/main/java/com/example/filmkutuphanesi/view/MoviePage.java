package com.example.filmkutuphanesi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmkutuphanesi.Adapter.FilmAdapter;
import com.example.filmkutuphanesi.Database.SessionManager;
import com.example.filmkutuphanesi.R;
import com.example.filmkutuphanesi.Strategy.GenreSearchStrategy;
import com.example.filmkutuphanesi.Strategy.MovieLibrary;
import com.example.filmkutuphanesi.Strategy.ReleaseYearSearchStrategy;
import com.example.filmkutuphanesi.Strategy.SearchStrategy;
import com.example.filmkutuphanesi.Strategy.TitleSearchStrategy;
import com.example.filmkutuphanesi.model.Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviePage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FilmAdapter filmAdapter;
    private EditText editTextSearch;
    private Button buttonSearch;
    private Spinner spinnerSearchStrategy;




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
        spinnerSearchStrategy = findViewById(R.id.spinnerSearchStrategy);
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonSearch = findViewById(R.id.buttonSearch);



        List<String> searchStrategies = Arrays.asList("Başlık", "Tür", "Çıkış Yılı");

// Spinner'a Adapter'ı ayarlayın
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, searchStrategies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearchStrategy.setAdapter(adapter);



        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten arama terimini al
                String searchTerm = editTextSearch.getText().toString();

                // Spinner'dan seçilen arama stratejisini al
                String selectedStrategy = (String) spinnerSearchStrategy.getSelectedItem();

                // Seçilen arama stratejisine göre arama yapma işlemi
                performSearch(selectedStrategy, searchTerm);
            }
        });

        deneme();
    }




    private void performSearch(String selectedStrategy, String searchTerm) {
        // Seçilen arama stratejisine göre uygun SearchStrategy sınıfını oluşturun
        SearchStrategy strategy = null;
        switch (selectedStrategy) {
            case "Başlık":
                strategy = new TitleSearchStrategy();
                break;
            case "Tür":
                strategy = new GenreSearchStrategy();
                break;
            case "Çıkış Yılı":
                strategy = new ReleaseYearSearchStrategy();
                break;
        }

        if (strategy != null) {
            // Arama stratejisi ile arama yapma işlemi
            List<Film> searchResult = MovieLibrary.searchFilms(strategy, searchTerm);

          recyclerView.setAdapter(new FilmAdapter(searchResult));
        }
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

        filmList.add(new Film("Vizontele", "Yılmaz Erdoğan, Ömer Faruk Sorak", Arrays.asList("Yılmaz Erdoğan", "Demet Akbağ"), "Komedi", 2001, 110));
        filmList.add(new Film("Eşkıya", "Yavuz Turgul", Arrays.asList("Şener Şen", "Uğur Yücel"), "Drama", 1996, 128));
        filmList.add(new Film("Aşk Tesadüfleri Sever", "Ömer Faruk Sorak", Arrays.asList("Mehmet Günsür", "Belçim Bilgin"), "Romantik", 2011, 118));
        filmList.add(new Film("Kelebeğin Rüyası", "Yılmaz Erdoğan", Arrays.asList("Kıvanç Tatlıtuğ", "Mert Fırat"), "Drama", 2013, 138));
        filmList.add(new Film("G.O.R.A.", "Ömer Faruk Sorak", Arrays.asList("Cem Yılmaz", "Özge Özberk"), "Komedi", 2004, 127));
        filmList.add(new Film("Babam ve Oğlum", "Çağan Irmak", Arrays.asList("Çetin Tekindor", "Fikret Kuşkan"), "Drama", 2005, 112));
        filmList.add(new Film("Muhsin Bey", "Yavuz Turgul", Arrays.asList("Şener Şen", "Ugur Yücel"), "Drama", 1987, 111));
        filmList.add(new Film("Nefes: Vatan Sağolsun", "Levent Semerci", Arrays.asList("Mete Horozoğlu", "İbrahim Akoz"), "Savaş", 2009, 128));
        filmList.add(new Film("Eğreti Gelin", "Ömer Kavur", Arrays.asList("Tarık Akan", "Müjde Ar"), "Drama", 1983, 92));
        filmList.add(new Film("Beynelmilel", "Muharrem Gülmez, Sirri Süreyya Önder", Arrays.asList("Cezmi Baskın", "Hakan Yılmaz"), "Drama", 2006, 101));

        // İstediğiniz kadar film ekleyebilirsiniz.

        return filmList;
    }


    public void deneme(){


        // Film listesini oluşturalım ve bazı filmleri ekleyelim
        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Vizontele", "Yılmaz Erdoğan, Ömer Faruk Sorak", Arrays.asList("Yılmaz Erdoğan", "Demet Akbağ"), "Komedi", 2001, 110));
        filmList.add(new Film("Eşkıya", "Yavuz Turgul", Arrays.asList("Şener Şen", "Uğur Yücel"), "Drama", 1996, 128));
        filmList.add(new Film("Aşk Tesadüfleri Sever", "Ömer Faruk Sorak", Arrays.asList("Mehmet Günsür", "Belçim Bilgin"), "Romantik", 2011, 118));
        filmList.add(new Film("Kelebeğin Rüyası", "Yılmaz Erdoğan", Arrays.asList("Kıvanç Tatlıtuğ", "Mert Fırat"), "Drama", 2013, 138));
        filmList.add(new Film("G.O.R.A.", "Ömer Faruk Sorak", Arrays.asList("Cem Yılmaz", "Özge Özberk"), "Komedi", 2004, 127));
        filmList.add(new Film("Babam ve Oğlum", "Çağan Irmak", Arrays.asList("Çetin Tekindor", "Fikret Kuşkan"), "Drama", 2005, 112));
        filmList.add(new Film("Muhsin Bey", "Yavuz Turgul", Arrays.asList("Şener Şen", "Ugur Yücel"), "Drama", 1987, 111));
        filmList.add(new Film("Nefes: Vatan Sağolsun", "Levent Semerci", Arrays.asList("Mete Horozoğlu", "İbrahim Akoz"), "Savaş", 2009, 128));
        filmList.add(new Film("Eğreti Gelin", "Ömer Kavur", Arrays.asList("Tarık Akan", "Müjde Ar"), "Drama", 1983, 92));
        filmList.add(new Film("Beynelmilel", "Muharrem Gülmez, Sirri Süreyya Önder", Arrays.asList("Cezmi Baskın", "Hakan Yılmaz"), "Drama", 2006, 101));

        // MovieLibrary nesnesini oluşturalım ve film listesini içeri aktaralım
        MovieLibrary library = new MovieLibrary(filmList);

        // Farklı arama stratejilerini kullanarak arama yapma
        List<Film> titleSearchResult = library.searchFilms(new TitleSearchStrategy(), "The Godfather");
        // Sonuçların işlenmesi...


        List<Film> genreSearchResult = library.searchFilms(new GenreSearchStrategy(), "Action");
        // Sonuçların işlenmesi...

        List<Film> releaseYearSearchResult = library.searchFilms(new ReleaseYearSearchStrategy(), "2008");
        // Sonuçların işlenmesi...
    }
    }

