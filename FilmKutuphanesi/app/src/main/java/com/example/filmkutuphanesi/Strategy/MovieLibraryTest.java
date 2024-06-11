package com.example.filmkutuphanesi.Strategy;


import static junit.framework.TestCase.assertEquals;

import com.example.filmkutuphanesi.model.Film;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieLibraryTest {

    @Test
    public void testTitleSearchStrategy() {
        // Film listesini oluşturalım ve bazı filmleri ekleyelim
        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Vizontele", "Yılmaz Erdoğan, Ömer Faruk Sorak", Arrays.asList("Yılmaz Erdoğan", "Demet Akbağ"), "Komedi", 2001, 110));
        filmList.add(new Film("The Godfather", "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino"), "Crime", 1972, 175));
        filmList.add(new Film("Pulp Fiction", "Quentin Tarantino", Arrays.asList("John Travolta", "Uma Thurman"), "Crime", 1994, 154));
        filmList.add(new Film("Inception", "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", 2010, 148));

        // MovieLibrary nesnesini oluşturalım ve film listesini içeri aktaralım
        MovieLibrary library = new MovieLibrary(filmList);

        // Arama stratejisini oluşturalım ve film adıyla arama yapalım
        List<Film> titleSearchResult = library.searchFilms(new TitleSearchStrategy(), "The Godfather");

        // Sonucun beklenen sonuçla eşleşip eşleşmediğini kontrol edelim
        assertEquals(1, titleSearchResult.size());
        assertEquals("The Godfather", titleSearchResult.get(0).getAd());
    }

    @Test
    public void testGenreSearchStrategy() {
        // Film listesini oluşturalım ve bazı filmleri ekleyelim
        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Pulp Fiction", "Quentin Tarantino", Arrays.asList("John Travolta", "Uma Thurman"), "Crime", 1994, 154));
        filmList.add(new Film("Inception", "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", 2010, 148));

        // MovieLibrary nesnesini oluşturalım ve film listesini içeri aktaralım
        MovieLibrary library = new MovieLibrary(filmList);

        // Arama stratejisini oluşturalım ve film türüyle arama yapalım
        List<Film> genreSearchResult = library.searchFilms(new GenreSearchStrategy(), "Crime");

        // Sonucun beklenen sonuçla eşleşip eşleşmediğini kontrol edelim
        assertEquals(1, genreSearchResult.size());
        assertEquals("Pulp Fiction", genreSearchResult.get(0).getAd());
    }

    @Test
    public void testReleaseYearSearchStrategy() {
        // Film listesini oluşturalım ve bazı filmleri ekleyelim
        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("The Godfather", "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino"), "Crime", 1972, 175));
        filmList.add(new Film("Pulp Fiction", "Quentin Tarantino", Arrays.asList("John Travolta", "Uma Thurman"), "Crime", 1994, 154));
        filmList.add(new Film("Inception", "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", 2010, 148));

        // MovieLibrary nesnesini oluşturalım ve film listesini içeri aktaralım
        MovieLibrary library = new MovieLibrary(filmList);

        // Arama stratejisini oluşturalım ve yayın yılıyla arama yapalım
        List<Film> releaseYearSearchResult = library.searchFilms(new ReleaseYearSearchStrategy(), "1972");

        // Sonucun beklenen sonuçla eşleşip eşleşmediğini kontrol edelim
        assertEquals(1, releaseYearSearchResult.size());
        assertEquals("The Godfather", releaseYearSearchResult.get(0).getAd());
    }
}

