package com.example.filmkutuphanesi.Strategy;

import com.example.filmkutuphanesi.model.Film;

import java.util.List;

public interface SearchStrategy {
    List<Film> search(List<Film> filmList, String query);
}

