package com.example.filmkutuphanesi.Strategy;

import com.example.filmkutuphanesi.model.Film;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class TitleSearchStrategy implements SearchStrategy {
    @Override
    public List<Film> search(List<Film> filmList, String query) {
        List<Film> result = new ArrayList<>();
        for (Film film : filmList) {
            if (film.getAd().equalsIgnoreCase(query)) {
                result.add(film);
            }
        }
        return result;
    }
}


