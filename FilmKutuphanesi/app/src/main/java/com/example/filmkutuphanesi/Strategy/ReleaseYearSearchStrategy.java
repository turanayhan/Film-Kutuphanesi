package com.example.filmkutuphanesi.Strategy;


import com.example.filmkutuphanesi.model.Film;

import java.util.ArrayList;
import java.util.List;

public class ReleaseYearSearchStrategy implements SearchStrategy {
    @Override
    public List<Film> search(List<Film> filmList, String query) {
        List<Film> result = new ArrayList<>();
        int searchYear = Integer.parseInt(query);
        for (Film film : filmList) {
            if (film.getCikisYili() == searchYear) {
                result.add(film);
            }
        }
        return result;
    }
}