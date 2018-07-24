package com.alanueyn.projects.itunesalbumviewer.presenter.list;

import android.annotation.SuppressLint;
import android.util.Log;

import com.alanueyn.projects.itunesalbumviewer.model.Album;
import com.alanueyn.projects.itunesalbumviewer.model.AlbumResult;
import com.alanueyn.projects.itunesalbumviewer.repository.ItunesRepository;
import com.alanueyn.projects.itunesalbumviewer.view.list.AlbumView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class ListPresenterImpl implements ListPresenter {

    private final String TAG = "ListPresenter";

    ItunesRepository repository;
    AlbumView view;

    private CompositeDisposable disposable;



    @Inject
    public ListPresenterImpl(AlbumView view, ItunesRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    @SuppressLint("CheckResult")
    @Override
    public void setAlbumObservable(Observable<CharSequence> observable) {

        if (disposable == null) {
            disposable = new CompositeDisposable();
        }

        disposable.add(observable
                .debounce(400, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .distinctUntilChanged()
                .filter(s -> {
                    return !s.isEmpty();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .switchMap(query -> repository.getAlbums(query))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albumResult -> view.showAlbums(albumResult.getAlbums()), throwable -> view.showErrorMessage())
        );
        Log.d(TAG,"Subscribed!");

    }

    @Override
    public void pause() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
            Log.d(TAG,"Disposed!");
        }


    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
            Log.d(TAG,"Disposed!");
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
