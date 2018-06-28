package com.trying.developing.unsplashapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.trying.developing.unsplashapp.R;
import com.trying.developing.unsplashapp.model.Photo;

import java.util.List;

/**
 * Created by developing on 6/19/2018.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoHolders>{
    private Context mContext;
    private List<Photo> list;

    public PhotosAdapter(Context mContext, List<Photo> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public PhotoHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.photos_items,parent,false);
        PhotoHolders photoHolders=new PhotoHolders(view);

        return photoHolders;
    }

    @Override
    public void onBindViewHolder(PhotoHolders holder, int position) {

        final Photo image=list.get(position);

        Picasso.with(mContext).load(image.getRaw()).into(holder.photos);

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
    }
}
