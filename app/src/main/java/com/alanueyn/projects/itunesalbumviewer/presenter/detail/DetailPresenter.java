package com.alanueyn.projects.itunesalbumviewer.presenter.detail;

import com.alanueyn.projects.itunesalbumviewer.presenter.BasePresenter;

/**
 * The interface of presenter that will be communicate with DetailActivity
 */

public interface DetailPresenter extends BasePresenter {

    void loadSongList(String albumId);

}
