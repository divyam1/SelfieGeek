package com.example.selfiegeek.Adapter;

import android.app.Activity;
import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.selfiegeek.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by DU on 4/17/2017.
 */
public class ImagesGridAdapter extends RecyclerView.Adapter<ImagesGridAdapter.ImagesViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<URL> images;
    private RecyclerView recyclerView;
    ImageView imageView;

    public ImagesGridAdapter(Context context, ArrayList<URL> images, Activity activity, RecyclerView recyclerView) {
        this.context = context;
        this.images = images;
        this.activity = activity;
        this.recyclerView = recyclerView;
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder {
        public ImagesViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_element, parent, false);
        imageView = (ImageView) view.findViewById(R.id.gridImageView);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ImagesViewHolder holder, int position) {

        URL url = images.get(position);
        Picasso.with(context).load(String.valueOf(url))
                .into(imageView);
    }


    @Override
    public int getItemCount() {
        return images.size();
    }


}

