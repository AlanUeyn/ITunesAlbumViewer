package com.alanueyn.projects.itunesalbumviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The main container of JSON respond that holds list of requested songs of albums.
 */

public class SongResult {

    @SerializedName("results")
    private List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }
}
