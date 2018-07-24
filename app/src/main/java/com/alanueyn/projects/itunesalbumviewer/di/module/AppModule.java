package com.alanueyn.projects.itunesalbumviewer.di.module;


import android.app.Application;
import android.content.Context;

import com.alanueyn.projects.itunesalbumviewer.BuildConfig;
import com.alanueyn.projects.itunesalbumviewer.repository.ItunesRepository;
import com.alanueyn.projects.itunesalbumviewer.repository.ItunesRepositoryImpl;
import com.alanueyn.projects.itunesalbumviewer.service.ItunesService;
import com.alanueyn.projects.itunesalbumviewer.service.ItunesServiceFactory;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * AppModule provides the main dependencies for our app (like Retrofit Service, repository)
 */

@Module
public abstract class AppModule {

    @Singleton
    @Provides
    static ItunesService provideItunesService() {
        return ItunesServiceFactory.createItunesService(BuildConfig.DEBUG);
    }

    @Singleton
    @Binds
    abstract Context provideContext(Application application);

    @Singleton
    @Binds
    abstract ItunesRepository provideItunesRepository(ItunesRepositoryImpl repo);



}
