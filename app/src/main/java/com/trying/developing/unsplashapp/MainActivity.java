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
    List<Photo> data;
    APIService apiService;
    Gson gson;
    String Photos="";
    Photo photo;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewTest_id);
        gson = new Gson();
        apiService = APIUrl.getService();

//
//        if (savedInstanceState != null) {
//            Photos = savedInstanceState.getString("photos");
//            Type type = new TypeToken<List<Photo>>() {
//            }.getType();
//            data = gson.fromJson(Photos, type);
//            photosAdapter = new PhotosAdapter(MainActivity.this, data);
//            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, getSpan());
//            recyclerView.setLayoutManager(layoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.setAdapter(photosAdapter);
//
//
//        } else {
//            getPhoto();
//
//        }

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, getSpan());
        recyclerView.setLayoutManager(layoutManager);
         recyclerView.setItemAnimator(new DefaultItemAnimator());



        Call<List<Photo>>call=apiService.getphoto();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                data=response.body();
                Log.d("ssss",data.toString());
                photosAdapter=new PhotosAdapter(MainActivity.this,data);
                recyclerView.setAdapter(photosAdapter);


            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }



    });

    }




    private int getSpan() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return 2;
        }
        return 1;
    }
}
//
//
//    public void getPhoto(){
//        apiService.getphoto().enqueue(new Callback<List<Photo>>() {
//            @Override
//            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
//
//                if(response.isSuccessful()){
//
//                    data=response.body();
//
//                    Photos=gson.toJson(data);
//                    SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor=sharedPreferences.edit();
//                    editor.putString("photos",Photos);
//                    editor.apply();
//                    photosAdapter=new PhotosAdapter(MainActivity.this,data);
//                    RecyclerView.LayoutManager layoutManager=new GridLayoutManager(MainActivity.this,getSpan());
//                    recyclerView.setLayoutManager(layoutManager);
//                    recyclerView.setItemAnimator(new DefaultItemAnimator());
//                    recyclerView.setAdapter(photosAdapter);
//
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Photo>> call, Throwable t) {
//
//                Toast.makeText(MainActivity.this,"there's no internet connection",Toast.LENGTH_LONG).show();
//                SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
//                Photos=sharedPreferences.getString("photos","");
//                Type type=new TypeToken<List<Photo>>(){
//                }.getType();
//                data=gson.fromJson(Photos,type);
//                photosAdapter=new PhotosAdapter(MainActivity.this,data);
//                RecyclerView.LayoutManager layoutManager=new GridLayoutManager(MainActivity.this,getSpan());
//                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setItemAnimator(new DefaultItemAnimator());
//                recyclerView.setAdapter(photosAdapter);
//
//
//            }
//        });
//
//    }



