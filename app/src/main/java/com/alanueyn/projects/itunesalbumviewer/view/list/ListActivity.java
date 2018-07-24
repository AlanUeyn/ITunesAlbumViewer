package com.alanueyn.projects.itunesalbumviewer.view.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.alanueyn.projects.itunesalbumviewer.R;
import com.alanueyn.projects.itunesalbumviewer.model.Album;
import com.alanueyn.projects.itunesalbumviewer.presenter.list.ListPresenter;
import com.alanueyn.projects.itunesalbumviewer.view.adapter.AlbumsAdapter;
import com.alanueyn.projects.itunesalbumviewer.view.detail.DetailActivity;
import com.alanueyn.projects.itunesalbumviewer.view.listener.ClickListener;
import com.alanueyn.projects.itunesalbumviewer.view.listener.RecyclerTouchListener;
import com.jakewharton.rxbinding2.widget.RxSearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.Observable;


public class ListActivity extends DaggerAppCompatActivity implements AlbumView {


    private static String KEY = "ALBUM";

    @Inject
    ListPresenter presenter;

    private TextView greetingsText;
    private AlbumsAdapter adapter;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private Observable<CharSequence> albumObservable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = (RecyclerView) findViewById(R.id.album_recycler);
        searchView = findViewById(R.id.search_view);
        greetingsText = findViewById(R.id.greetings_text);
        setupRecycler();

    }

    //Handling the lifecycle of an activty (unsubscribe)

    @Override
    protected void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    /* Create and attach RxBinding to searchview for reactive search feature */

    @Override
    protected void onStart() {
        super.onStart();
        albumObservable = RxSearchView.queryTextChanges(searchView);
        presenter.setAlbumObservable(albumObservable);
    }

    //Show result of presenter working
    @Override
    public void showAlbums(List<Album> albums) {
        if (albums.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            greetingsText.setVisibility(View.VISIBLE);
            greetingsText.setText(R.string.list_nothing_found);
        }
        else {
            recyclerView.setVisibility(View.VISIBLE);
            greetingsText.setVisibility(View.GONE);
            Collections.sort(albums, (o1, o2) -> o1.getCollectionName().compareTo(o2.getCollectionName()));
            adapter.getAlbums().clear();
            adapter.getAlbums().addAll(albums);
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void showErrorMessage() {
        Toast.makeText(getApplicationContext(), "Network connection error", Toast.LENGTH_SHORT).show();
    }

    private void startDetailActivity(Album album) {
        Intent i = new Intent(ListActivity.this, DetailActivity.class);
        Bundle b = new Bundle();
        b.putSerializable(KEY, album);
        i.putExtras(b);
        startActivity(i);
    }

    //Prepare our recyclerview for correct working
    private void setupRecycler() {
        adapter = new AlbumsAdapter();
        adapter.setAlbums(new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int posititon) {
                Album album = adapter.getAlbums().get(posititon);
                startDetailActivity(album);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        //Add item dividers for recyclerview
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }


}
