package com.example.filmkutuphanesi.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.filmkutuphanesi.R;
import com.example.filmkutuphanesi.model.Film;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private List<Film> filmList;

    public FilmAdapter(List<Film> filmList) {
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = filmList.get(position);
        holder.filmAdi.setText(film.getAd());
        holder.yonetmen.setText(film.getYonetmen());
        holder.oyuncular.setText(film.getOyuncular().toString());
        holder.tur.setText(film.getTur());
        holder.cikisYili.setText(String.valueOf(film.getCikisYili()));
        holder.sure.setText(String.valueOf(film.getSure()) + " dakika");
    }

    @Override
    public int getItemCount() {

        return filmList.size();
    }
    public void test(){

        System.out.println(filmList.toString());
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        TextView filmAdi, yonetmen, oyuncular, tur, cikisYili, sure;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            filmAdi = itemView.findViewById(R.id.filmAdi);
            yonetmen = itemView.findViewById(R.id.yonetmen);
            oyuncular = itemView.findViewById(R.id.oyuncular);
            tur = itemView.findViewById(R.id.tur);
            cikisYili = itemView.findViewById(R.id.cikisYili);
            sure = itemView.findViewById(R.id.sure);
        }
    }
}

