package com.example.filmkutuphanesi.Builder;

import com.example.filmkutuphanesi.model.Film;

import java.util.List;

public class FilmBuilder {
    public String ad;
    public String yonetmen;
    public List<String> oyuncular;
    public String tur;
    public int cikisYili;
    public int sure;

    public FilmBuilder(String ad) {
        this.ad = ad;
    }

    public FilmBuilder yonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
        return this;
    }

    public FilmBuilder oyuncular(List<String> oyuncular) {
        this.oyuncular = oyuncular;
        return this;
    }

    public FilmBuilder tur(String tur) {
        this.tur = tur;
        return this;
    }

    public FilmBuilder cikisYili(int cikisYili) {
        this.cikisYili = cikisYili;
        return this;
    }

    public FilmBuilder sure(int sure) {
        this.sure = sure;
        return this;
    }

    public Film build() {
        return new Film(this);
    }
}
