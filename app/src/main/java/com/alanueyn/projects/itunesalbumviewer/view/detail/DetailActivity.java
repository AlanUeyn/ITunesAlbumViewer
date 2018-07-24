package com.alanueyn.projects.itunesalbumviewer.view.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alanueyn.projects.itunesalbumviewer.R;
import com.alanueyn.projects.itunesalbumviewer.model.Album;
import com.alanueyn.projects.itunesalbumviewer.model.Song;
import com.alanueyn.projects.itunesalbumviewer.presenter.detail.DetailPresenter;
import com.alanueyn.projects.itunesalbumviewer.view.adapter.SongAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;



public class DetailActivity extends DaggerAppCompatActivity implements DetailView {

    private static String KEY = "ALBUM";

    @Inject
    DetailPresenter presenter;

    ProgressBar progressBar;
    RecyclerView recyclerView;
    SongAdapter adapter;

    TextView title;
    TextView artist;
    TextView genre;
    TextView copyright;
    TextView releaseDate;
    TextView year;
    ImageView artwork;

    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.detail_progressbar);
        recyclerView = findViewById(R.id.detail_recyclerview);
        title = findViewById(R.id.detail_album_title);
        artist = findViewById(R.id.detail_artist_name);
        genre = findViewById(R.id.detail_genre);
        copyright = findViewById(R.id.detail_copyright);
        year = findViewById(R.id.detail_year);
        releaseDate = findViewById(R.id.detail_release_date);
        artwork = findViewById(R.id.detail_album_artwork);
        setupRecycler();

    }



    @Override
    protected void onStart() {
        super.onStart();
        //Get the album serializable from list activity
        Intent i = getIntent();
        Bundle b = i.getExtras();
        //Check that bundle is not null avoiding NullPointerException
        if (b != null) {
            album = (Album)b.getSerializable(KEY);
            setLayout();
            //Invoke presenter method which loads album songs list
            presenter.loadSongList(album.getCollectionId());
        }
    }


    //Handling the lifecycle of an activity (unsubscribe)
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }


    @Override
    public void showSongList(List<Song> songs) {
        progressBar.setVisibility(View.GONE);
        songs.remove(0);
        adapter.setSongs(songs);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_SHORT).show();
    }


    private void setLayout() {
        title.setText(album.getCollectionName());
        artist.setText(album.getArtistName());
        genre.setText(album.getPrimaryGenreName());
        copyright.setText(album.getCopyright());
        year.setText(album.getReleaseDate().substring(0,4));
        releaseDate.setText(album.getReleaseDate().substring(0,10));
        Picasso.get().load(album.getArtworkUrl()).into(artwork);


    }

    private void setupRecycler() {
        adapter = new SongAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


}
