package com.alanueyn.projects.itunesalbumviewer.repository;

import com.alanueyn.projects.itunesalbumviewer.model.AlbumResult;
import com.alanueyn.projects.itunesalbumviewer.model.SongResult;
import io.reactivex.Observable;

/**
 * The repository layer which takes the data from service and give it to presenter
 */

public interface ItunesRepository {

    Observable<AlbumResult> getAlbums(String artist);

    Observable<SongResult> getSongs(String albumId);

}
