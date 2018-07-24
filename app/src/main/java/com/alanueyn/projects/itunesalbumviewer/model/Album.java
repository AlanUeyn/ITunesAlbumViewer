package com.alanueyn.projects.itunesalbumviewer.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * POJO album class serialized by GSON @SerializedName annotation
 */

public class Album implements Serializable {

    @SerializedName(value = "collectionId")
    private String collectionId;

    @SerializedName(value = "collectionName")
    private String collectionName;

    @SerializedName(value = "artistName")
    private String artistName;

    @SerializedName(value = "artworkUrl100")
    private String artworkUrl;

    @SerializedName(value = "collectionPrice")
    private String collectionPrice;

    @SerializedName(value = "primaryGenreName")
    private String primaryGenreName;

    @SerializedName(value = "currency")
    private String currency;

    @SerializedName(value = "trackCount")
    private String trackCount;

    @SerializedName(value = "copyright")
    private String copyright;

    @SerializedName(value = "releaseDate")
    private String releaseDate;

    public Album(String collectionId, String collectionName, String artistName,
                 String artworkUrl, String collectionPrice, String primaryGenreName,
                 String currency, String trackCount, String copyright, String releaseDate) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.artworkUrl = artworkUrl;
        this.collectionPrice = collectionPrice;
        this.primaryGenreName = primaryGenreName;
        this.currency = currency;
        this.trackCount = trackCount;
        this.copyright = copyright;
        this.releaseDate = releaseDate;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
