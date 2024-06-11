package com.example.filmkutuphanesi.Strategy;

import com.example.filmkutuphanesi.model.Film;

import java.util.ArrayList;
import java.util.List;

public class GenreSearchStrategy implements SearchStrategy {
    @Override
    public List<Film> search(List<Film> filmList, String query) {
        List<Film> result = new ArrayList<>();
        for (Film film : filmList) {
            if (film.getTur().equalsIgnoreCase(query)) {
                result.add(film);
            }
        }
        return result;
    }
}
