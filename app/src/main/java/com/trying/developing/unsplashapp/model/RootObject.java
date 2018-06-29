package com.trying.developing.unsplashapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by developing on 6/29/2018.
 */

public class RootObject {

    @SerializedName("urls")
    public Photo url;

    public Photo getUrl() {
        return url;
    }

    public void setUrl(Photo url) {
        this.url = url;
    }
}
