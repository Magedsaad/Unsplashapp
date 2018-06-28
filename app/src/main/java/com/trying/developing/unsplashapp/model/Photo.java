package com.trying.developing.unsplashapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by developing on 6/18/2018.
 */

public class Photo {

    @SerializedName("raw")
    public String raw ;
    @SerializedName("full")
    public String full ;
    @SerializedName("regular")
    public String regular ;
    @SerializedName("small")
    public String small ;
    @SerializedName("thumb")
    public String thumb ;

    public Photo() {
    }

    public Photo(String raw, String full, String regular, String small, String thumb) {
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
