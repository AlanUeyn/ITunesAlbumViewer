package com.alanueyn.projects.itunesalbumviewer.view.detail;

import com.alanueyn.projects.itunesalbumviewer.model.Song;

import java.util.List;

/**
 * Interface with methods which must be implemented in DetailActivity
 */

public interface DetailView {

    void showSongList(List<Song> songs);

    void showErrorMessage();

}
