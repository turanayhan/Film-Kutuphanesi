package com.example.filmkutuphanesi.model;

import java.util.List;

public class Film {
    private String ad;
    private String yonetmen;
    private List<String> oyuncular;
    private String tur;
    private int cikisYili;
    private int sure;

    public Film(String ad, String yonetmen, List<String> oyuncular, String tur, int cikisYili, int sure) {
        this.ad = ad;
        this.yonetmen = yonetmen;
        this.oyuncular = oyuncular;
        this.tur = tur;
        this.cikisYili = cikisYili;
        this.sure = sure;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public List<String> getOyuncular() {
        return oyuncular;
    }

    public void setOyuncular(List<String> oyuncular) {
        this.oyuncular = oyuncular;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getCikisYili() {
        return cikisYili;
    }

    public void setCikisYili(int cikisYili) {
        this.cikisYili = cikisYili;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }
}
