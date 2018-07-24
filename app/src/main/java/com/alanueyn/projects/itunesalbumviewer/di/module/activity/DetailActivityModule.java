package com.alanueyn.projects.itunesalbumviewer.di.module.activity;

import com.alanueyn.projects.itunesalbumviewer.presenter.detail.DetailPresenter;
import com.alanueyn.projects.itunesalbumviewer.presenter.detail.DetailPresenterImpl;
import com.alanueyn.projects.itunesalbumviewer.repository.ItunesRepository;
import com.alanueyn.projects.itunesalbumviewer.view.detail.DetailActivity;
import com.alanueyn.projects.itunesalbumviewer.view.detail.DetailView;

import dagger.Module;
import dagger.Provides;

/**
 * Provides all dependencies for DetailActivity and DetailPresenter
 */

@Module
public class DetailActivityModule {

    @Provides
    DetailPresenter provideDetailPresenter(DetailView view, ItunesRepository repository) {
        return new DetailPresenterImpl(view, repository);
    }

    @Provides
    DetailView provideDetailView(DetailActivity activity) {return activity;}

}
