package com.example.devwill.androidvideoplayerlisttest.VideoPlayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.devwill.androidvideoplayerlisttest.PlayList.RowData;
import com.example.devwill.androidvideoplayerlisttest.R;
import com.example.devwill.androidvideoplayerlisttest.VideoList;

import java.util.List;

public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView videoView;
    private  List<RowData> list;
    private int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);

        list = VideoList.getList();

        videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        mc.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Handle next click here
                next();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Handle previous click here
                prev();
            }
        });
        videoView.setMediaController(mc);
        play(position);
    }

    @Override
    protected void onPause() {
        videoView.stopPlayback();
        super.onPause();
    }

    private void play(int row){
        RowData rowData = list.get(row);
        String path = "android.resource://" + getPackageName() + "/" + rowData.getId();
        videoView.setVideoPath(path);
        videoView.start();
        playing = row;
    }
    private void next(){
        int row = 0;
        if(playing + 1 < list.size()){
            row = playing + 1;
        }
        play(row);
    }
    private void prev(){
        int row = list.size() - 1;
        if(playing - 1 > 0){
            row = playing - 1;
        }
        play(row);
    }
}
