package com.example.devwill.androidvideoplayerlisttest.VideoPlayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.devwill.androidvideoplayerlisttest.R;

public class VideoPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        Log.d("System.out", String.valueOf(intent.getIntExtra("position",0)));
    }
}
