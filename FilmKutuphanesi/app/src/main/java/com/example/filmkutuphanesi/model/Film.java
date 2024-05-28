package com.example.filmkutuphanesi.model;

import com.example.filmkutuphanesi.Builder.FilmBuilder;
import java.util.List;

public class Film {
    private String ad;
    private String yonetmen;
    private List<String> oyuncular;
    private String tur;
    private int cikisYili;
    private int sure;

    public Film(FilmBuilder builder) {
        this.ad = builder.ad;
        this.yonetmen = builder.yonetmen;
        this.oyuncular = builder.oyuncular;
        this.tur = builder.tur;
        this.cikisYili = builder.cikisYili;
        this.sure = builder.sure;
    }

    // Getter metotları

    public String getAd() {
        return ad;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public List<String> getOyuncular() {
        return oyuncular;
    }

    public String getTur() {
        return tur;
    }

    public int getCikisYili() {
        return cikisYili;
    }

    public int getSure() {
        return sure;
    }

    public static FilmBuilder builder(String ad) {
        return new FilmBuilder(ad);
    }
}
