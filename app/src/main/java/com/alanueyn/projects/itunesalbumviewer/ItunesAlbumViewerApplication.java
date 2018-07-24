package com.alanueyn.projects.itunesalbumviewer;

import com.alanueyn.projects.itunesalbumviewer.di.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Setting up the DI on application level
 */

public class ItunesAlbumViewerApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent
                .builder()
                .create(this);
    }

}
