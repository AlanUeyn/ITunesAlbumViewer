package com.alanueyn.projects.itunesalbumviewer.view.list;


import com.alanueyn.projects.itunesalbumviewer.model.Album;

import java.util.List;

/**
 * Interface with methods which must be implemented in ListActivity
 */

public interface AlbumView {

    void showAlbums(List<Album> albums);

    void showErrorMessage();


}
