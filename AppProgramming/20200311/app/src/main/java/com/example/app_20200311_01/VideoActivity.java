package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    protected VideoView mVideoView;
    protected MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getControls();
        prepareVideoViewVideo();
    }
    protected void getControls() {
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
            mVideoView.start();
        });
        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(v -> {
            mVideoView.pause();
        });

        mVideoView = findViewById(R.id.vv1);
    }

    protected void prepareVideoViewVideo() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/artic_fox");
        mVideoView.setVideoURI(uri);
        mVideoView.setOnPreparedListener(mp -> {
            mVideoView.start();
        });
    }
}