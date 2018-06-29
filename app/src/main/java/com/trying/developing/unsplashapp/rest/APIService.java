package com.trying.developing.unsplashapp.rest;

import com.trying.developing.unsplashapp.model.Photo;
import com.trying.developing.unsplashapp.model.RootObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by developing on 6/18/2018.
 */

public interface APIService  {

    @GET("photos/random/?client_id=c2eec0aeffbc275617287837249c98cb80a9c5a22d87a8999e10541f3dc603f7&count=10")
    Call<List<RootObject>> getphoto();

}
