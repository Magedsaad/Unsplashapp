package com.trying.developing.unsplashapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trying.developing.unsplashapp.adapter.PhotosAdapter;
import com.trying.developing.unsplashapp.model.Photo;
import com.trying.developing.unsplashapp.model.RootObject;
import com.trying.developing.unsplashapp.rest.APIService;
import com.trying.developing.unsplashapp.rest.APIUrl;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PhotosAdapter photosAdapter;
    List<RootObject> data;
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewTest_id);
        apiService = APIUrl.getService();


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Call<List<RootObject>> call = apiService.getphoto();
        call.enqueue(new Callback<List<RootObject>>() {
            @Override
            public void onResponse(Call<List<RootObject>> call, Response<List<RootObject>> response) {

                data = response.body();
                photosAdapter = new PhotosAdapter(MainActivity.this, data);
                recyclerView.setAdapter(photosAdapter);


            }

            @Override
            public void onFailure(Call<List<RootObject>> call, Throwable t) {

            }


        });

    }

}



