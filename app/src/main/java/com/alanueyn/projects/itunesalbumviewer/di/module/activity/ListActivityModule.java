package com.alanueyn.projects.itunesalbumviewer.di.module.activity;

import com.alanueyn.projects.itunesalbumviewer.presenter.list.ListPresenter;
import com.alanueyn.projects.itunesalbumviewer.presenter.list.ListPresenterImpl;
import com.alanueyn.projects.itunesalbumviewer.repository.ItunesRepository;
import com.alanueyn.projects.itunesalbumviewer.view.list.AlbumView;
import com.alanueyn.projects.itunesalbumviewer.view.list.ListActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Provides all dependencies for ListActivity and ListPresenter
 */

@Module
public class ListActivityModule {

    @Provides
    ListPresenter provideListPresenter(AlbumView albumView, ItunesRepository repository) {
        return new ListPresenterImpl(albumView, repository);
    }

    @Provides
    AlbumView provideMainView(ListActivity activity) {
        return activity;
    }

}
