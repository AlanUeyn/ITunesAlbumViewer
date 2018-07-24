package com.alanueyn.projects.itunesalbumviewer.di.component;


import com.alanueyn.projects.itunesalbumviewer.ItunesAlbumViewerApplication;
import com.alanueyn.projects.itunesalbumviewer.di.module.ActivityBuilder;
import com.alanueyn.projects.itunesalbumviewer.di.module.AppModule;
import javax.inject.Singleton;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


/**
 * The main DI component of our app.
 *
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<ItunesAlbumViewerApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ItunesAlbumViewerApplication> {}


}
