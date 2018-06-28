package com.trying.developing.unsplashapp.rest;

/**
 * Created by developing on 6/18/2018.
 */

public class APIUrl {

    public static final String BasrUrl="https://api.unsplash.com/";

    public static  APIService getService(){
        return   RestClient.getClient(BasrUrl).create(APIService.class);
    }
}
