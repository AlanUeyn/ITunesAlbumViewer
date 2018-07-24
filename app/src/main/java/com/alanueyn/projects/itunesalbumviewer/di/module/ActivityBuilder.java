package com.alanueyn.projects.itunesalbumviewer.di.module;

import com.alanueyn.projects.itunesalbumviewer.di.module.activity.DetailActivityModule;
import com.alanueyn.projects.itunesalbumviewer.di.module.activity.ListActivityModule;
import com.alanueyn.projects.itunesalbumviewer.view.detail.DetailActivity;
import com.alanueyn.projects.itunesalbumviewer.view.list.ListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This modules contributes AndroidInjector to our activities
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = ListActivityModule.class)
    abstract ListActivity bindListActivity();

    @ContributesAndroidInjector(modules = DetailActivityModule.class)
    abstract DetailActivity bindDetailActivity();

}
