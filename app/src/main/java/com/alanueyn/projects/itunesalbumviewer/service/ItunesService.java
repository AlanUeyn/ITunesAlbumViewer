package com.alanueyn.projects.itunesalbumviewer.service;

import com.alanueyn.projects.itunesalbumviewer.model.AlbumResult;
import com.alanueyn.projects.itunesalbumviewer.model.SongResult;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesService {

    @GET("/search")
    Observable<AlbumResult> getAlbumsByArtist(@Query(value = "term")String term,
                                              @Query(value = "media")String media,
                                              @Query(value = "entity")String entity);

    @GET("/lookup")
    Observable<SongResult> getSongsByAlbum(@Query(value = "id")String id,
                                           @Query(value = "entity")String entity);


}
