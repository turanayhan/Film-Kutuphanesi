package com.example.filmkutuphanesi;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.filmkutuphanesi.Adapter.FilmAdapter;
import com.example.filmkutuphanesi.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testFilmAdapter() {
        // Test için film listesi oluşturuluyor
        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Once Upon a Time in Hollywood", "Quentin Tarantino", new ArrayList<>(), "Drama", 2019, 161));
        filmList.add(new Film("Forrest Gump", "Robert Zemeckis", new ArrayList<>(), "Drama", 1994, 142));

        // FilmAdapter örneği oluşturuluyor
        FilmAdapter adapter = new FilmAdapter(filmList);

        // getItemCount() metodu doğru sayıyı döndürüyor mu kontrol ed
        assertEquals(filmList.size(), adapter.getItemCount());

    }
}