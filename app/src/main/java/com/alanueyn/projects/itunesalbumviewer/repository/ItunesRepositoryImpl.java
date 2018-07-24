package com.alanueyn.projects.itunesalbumviewer.repository;

import com.alanueyn.projects.itunesalbumviewer.model.AlbumResult;
import com.alanueyn.projects.itunesalbumviewer.model.SongResult;
import com.alanueyn.projects.itunesalbumviewer.service.ItunesService;

import javax.inject.Inject;
import io.reactivex.Observable;

public class ItunesRepositoryImpl implements ItunesRepository {

    //Constants for request queries
    private static final String ALBUM_MEDIA = "music";
    private static final String ALBUM_ENTITY = "album";
    private static final String SONG_ENTITY = "song";

    public final ItunesService service;

    @Inject
    public ItunesRepositoryImpl(ItunesService service) {
        this.service = service;
    }

    @Override
    public Observable<AlbumResult> getAlbums(String artist) {
        return service.getAlbumsByArtist(artist, ALBUM_MEDIA, ALBUM_ENTITY);
    }

    @Override
    public Observable<SongResult> getSongs(String albumId) {
        return service.getSongsByAlbum(albumId, SONG_ENTITY);
    }

}
