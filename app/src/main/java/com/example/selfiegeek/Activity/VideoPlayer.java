package com.example.selfiegeek.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.selfiegeek.R;

public class VideoPlayer extends AppCompatActivity {
    Uri url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        final VideoView videoView =
                (VideoView) findViewById(R.id.vidPlayer);
        Intent intent = getIntent();
        String str = (String) intent.getSerializableExtra("uri");

        videoView.setVideoPath(str);

        android.widget.MediaController mediaController = new android.widget.MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()  {
            @Override
            public void onPrepared(MediaPlayer mp) {
                /*Log.i(TAG, "Duration = " +
                        videoView.getDuration());*/
            }
        });

        videoView.start();
    }
}
