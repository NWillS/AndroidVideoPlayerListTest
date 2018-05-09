package com.example.devwill.androidvideoplayerlisttest.PlayList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.devwill.androidvideoplayerlisttest.R;

public class VideoListViewHolder extends RecyclerView.ViewHolder {
    private final TextView videoNameTextView;
    private boolean playing;

    public VideoListViewHolder(View itemView) {
        super(itemView);
        videoNameTextView = (TextView)itemView.findViewById(R.id.videoNameTextView);
        playing = false;
    }

    public TextView getVideoNameTextView() {
        return videoNameTextView;
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

}
