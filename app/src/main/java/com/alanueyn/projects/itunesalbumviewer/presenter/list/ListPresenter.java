package com.alanueyn.projects.itunesalbumviewer.presenter.list;

import com.alanueyn.projects.itunesalbumviewer.presenter.BasePresenter;
import io.reactivex.Observable;

/**
 * The interface of presenter that will be communicate with ListActivity
 */

public interface ListPresenter extends BasePresenter {

    void setAlbumObservable(Observable<CharSequence> observable);

}
