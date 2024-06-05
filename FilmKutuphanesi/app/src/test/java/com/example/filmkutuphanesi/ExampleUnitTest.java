package com.example.filmkutuphanesi;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.Context;

import com.example.filmkutuphanesi.Adapter.FilmAdapter;
import com.example.filmkutuphanesi.Database.SessionManager;
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

        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Once Upon a Time in Hollywood", "Quentin Tarantino", new ArrayList<>(), "Drama", 2019, 161));
        filmList.add(new Film("Forrest Gump", "Robert Zemeckis", new ArrayList<>(), "Drama", 1994, 142));


        FilmAdapter adapter = new FilmAdapter(filmList);


        assertEquals(filmList.size(), adapter.getItemCount());

    }



    @Test
    public void testSingletonInstance() {
        // Gerçek bir Context nesnesi oluşturduk
        Context context = Mockito.mock(Context.class);

        // İlk çağrıda null dönmeli
        assertNull(SessionManager.getInstance(null));

        // İlk çağrıda bir instance oluşturulmalı
        assertNotNull(SessionManager.getInstance(context));

        // İkinci çağrıda ilk oluşturulan instance geri dönmeli
        assertSame(SessionManager.getInstance(context), SessionManager.getInstance(context));
    }











}