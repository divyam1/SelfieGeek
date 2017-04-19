package com.example.selfiegeek.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.selfiegeek.Activity.GridActivity;
import com.example.selfiegeek.Activity.VideoPlayer;
import com.example.selfiegeek.R;

import java.util.ArrayList;

/**
 * Created by DU on 4/17/2017.
 */
public class VideosGridAdapter extends RecyclerView.Adapter<VideosGridAdapter.VideosViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList<Uri>  videos;
    TextView vid;
    private RecyclerView recyclerView;


    public VideosGridAdapter(Context context, ArrayList<Uri> videos, Activity activity, RecyclerView recyclerView) {
        this.context = context;
        this.videos = videos;
        this.activity = activity;
        this.recyclerView = recyclerView;
    }
    public class VideosViewHolder extends RecyclerView.ViewHolder {
        public VideosViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public VideosGridAdapter.VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_video_element, parent, false);
        vid = (TextView) view.findViewById(R.id.videoElement);
        return new VideosGridAdapter.VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VideosGridAdapter.VideosViewHolder holder, final int position) {
        final Uri uri;
        uri = videos.get(position);
        vid.setText(uri.getLastPathSegment().toString());
        vid.requestFocus();

              vid.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent intent = new Intent(context, VideoPlayer.class);
                      intent.putExtra("uri",videos.get(position).toString());
                      context.startActivity(intent);
                  }
              });



    }

    @Override
    public int getItemCount() {
        return videos.size();
    }


}
