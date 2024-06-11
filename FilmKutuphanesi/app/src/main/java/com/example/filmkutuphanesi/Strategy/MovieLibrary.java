package com.example.filmkutuphanesi.Strategy;

import com.example.filmkutuphanesi.model.Film;

import java.util.List;

public class MovieLibrary {
    static List<Film> filmList;

    public MovieLibrary(List<Film> filmList) {
        this.filmList = filmList;
    }

    // Arama stratejisi ve terimi kullanarak filmleri arayan yöntem
    public static List<Film> searchFilms(SearchStrategy strategy, String searchTerm) {
        // Belirtilen stratejiye göre arama yap ve sonucu döndür
        return strategy.search(filmList, searchTerm);
    }
}
