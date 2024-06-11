package com.example.filmkutuphanesi.Strategy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.example.filmkutuphanesi.Strategy.GenreSearchStrategy;
import com.example.filmkutuphanesi.Strategy.MovieLibrary;
import com.example.filmkutuphanesi.Strategy.ReleaseYearSearchStrategy;
import com.example.filmkutuphanesi.Strategy.TitleSearchStrategy;
import com.example.filmkutuphanesi.model.Film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieLibraryTest {

    @Test
    public void testGenreSearchStrategy() {

        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Pulp Fiction", "Quentin Tarantino", Arrays.asList("John Travolta", "Uma Thurman"), "Crime", 1994, 154));
        filmList.add(new Film("Inception", "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", 2010, 148));
        filmList.add(new Film("The Hangover", "Todd Phillips", Arrays.asList("Bradley Cooper", "Ed Helms"), "Comedy", 2009, 100));
        filmList.add(new Film("The Grand Budapest Hotel", "Wes Anderson", Arrays.asList("Ralph Fiennes", "F. Murray Abraham"), "Comedy", 2014, 99));

       
        MovieLibrary library = new MovieLibrary(filmList);

        // Arama stratejisini oluşturalım ve komedi filmlerini arayalım
        List<Film> comedyMovies = library.searchFilms(new GenreSearchStrategy(), "Comedy");

        // Komedi filmlerinin sayısını kontrol edelim
        assertEquals(2, comedyMovies.size());
        // Komedi filmlerinden birinin adını kontrol edelim
        assertEquals("The Hangover", comedyMovies.get(0).getAd());

    }

}
