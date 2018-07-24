package com.alanueyn.projects.itunesalbumviewer.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alanueyn.projects.itunesalbumviewer.R;
import com.alanueyn.projects.itunesalbumviewer.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of custom Adapter for album recyclerview
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder> {

    private List<Album> albums = new ArrayList<>();

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Album> getAlbums() {
        return this.albums;
    }

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_item,parent,false);
        return new AlbumsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.title.setText(album.getCollectionName());
        holder.artist.setText(album.getArtistName());
        Picasso.get().load(album.getArtworkUrl()).into(holder.artwork);

    }


    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumsViewHolder extends RecyclerView.ViewHolder {

        private ImageView artwork;
        private TextView title;
        private TextView artist;

        AlbumsViewHolder(View itemView) {
            super(itemView);
            this.artwork = itemView.findViewById(R.id.album_artwork);
            this.title = itemView.findViewById(R.id.album_title);
            this.artist = itemView.findViewById(R.id.artist_name);
        }


    }


}
