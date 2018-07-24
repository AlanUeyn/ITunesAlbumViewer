package com.alanueyn.projects.itunesalbumviewer.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alanueyn.projects.itunesalbumviewer.R;
import com.alanueyn.projects.itunesalbumviewer.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of custom Adapter for song recyclerview
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{

    private List<Song> songs = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }



    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_songitem, parent, false);
        return new SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.number.setText(song.getTrackNumber());
        holder.title.setText(song.getTrackName());

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        private TextView number;
        private TextView title;

        SongViewHolder(View itemView) {
            super(itemView);
            this.number = itemView.findViewById(R.id.track_number);
            this.title = itemView.findViewById(R.id.track_title);
        }
    }

}
