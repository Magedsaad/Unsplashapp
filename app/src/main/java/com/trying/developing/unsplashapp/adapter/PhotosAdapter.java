package com.trying.developing.unsplashapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.trying.developing.unsplashapp.R;
import com.trying.developing.unsplashapp.model.RootObject;

import java.util.List;

/**
 * Created by developing on 6/19/2018.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoHolders>{
    private Context mContext;
    private List<RootObject> list;

    public PhotosAdapter(Context mContext, List<RootObject> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public PhotoHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoHolders(LayoutInflater.from(parent.getContext()).inflate(R.layout.photos_items,parent,false));
    }

    @Override
    public void onBindViewHolder(PhotoHolders holder, int position) {

        holder.bind(holder.getAdapterPosition());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PhotoHolders extends RecyclerView.ViewHolder {

        ImageView photos;


        public PhotoHolders(View itemView) {
            super(itemView);
            photos=(ImageView) itemView.findViewById(R.id.phototest_id);
        }


        void bind(int position){
            final RootObject image=list.get(position);
            Picasso.with(itemView.getContext()).load(image.getUrl().getRegular()).fit().into(photos);
            Log.i("haaaablllll", image.getUrl().getRegular());
        }
    }
}
