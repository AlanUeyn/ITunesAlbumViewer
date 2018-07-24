package com.alanueyn.projects.itunesalbumviewer.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * The main container of JSON respond that holds list of requested albums.
 */

public class AlbumResult implements Serializable {

    @SerializedName("results")
    private List<Album> albums;

    public AlbumResult(List<Album> albums) {
        this.albums = albums;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
