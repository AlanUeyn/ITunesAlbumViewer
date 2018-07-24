package com.alanueyn.projects.itunesalbumviewer.presenter.detail;


import android.util.Log;

import com.alanueyn.projects.itunesalbumviewer.repository.ItunesRepository;
import com.alanueyn.projects.itunesalbumviewer.view.detail.DetailView;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenterImpl implements DetailPresenter {

    private final String TAG = "DetailPresenter";

    private ItunesRepository repository;
    private DetailView view;

    //Make CompositeDisposable to control of unsubscribe from reactive stream
    private CompositeDisposable disposable;


    @Inject
    public DetailPresenterImpl(DetailView view, ItunesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadSongList(String albumId) {

        //Create new disposable and add to CompositeDisposable
        if(disposable == null) {
            disposable = new CompositeDisposable();
            disposable.add(repository.getSongs(albumId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(result -> view.showSongList(result.getSongs()), throwable -> view.showErrorMessage()));

            Log.d(TAG, "Subscribed!");
        }
    }

    /* Handling unsubscribe from stream */

    @Override
    public void pause() {
        if(disposable != null && !disposable.isDisposed()) {
            disposable.clear();
            Log.d(TAG, "Disposed!");
        }

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {
        if(disposable != null && !disposable.isDisposed()) {
            disposable.clear();
            Log.d(TAG, "Disposed!");
        }
    }

    @Override
    public void destroy() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
            Log.d(TAG, "Disposed!");
        }
    }
}
