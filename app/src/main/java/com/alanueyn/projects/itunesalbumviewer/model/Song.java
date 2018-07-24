package com.alanueyn.projects.itunesalbumviewer.model;



import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * POJO song class serialized by GSON @SerializedName annotation
 */

public class Song implements Serializable {

    @SerializedName("trackId")
    private String trackId;

    @SerializedName("trackName")
    private String trackName;

    @SerializedName("trackNumber")
    private String trackNumber;

    @SerializedName("trackTimeMillis")
    private String trackTimeMillis;

    public Song(String trackId, String trackName, String trackNumber, String trackTimeMillis) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackNumber = trackNumber;
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }
}
