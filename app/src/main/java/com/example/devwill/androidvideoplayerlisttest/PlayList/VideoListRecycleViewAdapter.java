package com.example.devwill.androidvideoplayerlisttest.PlayList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devwill.androidvideoplayerlisttest.R;

import java.util.List;

class VideoListRecycleViewAdapter extends RecyclerView.Adapter<VideoListViewHolder> {
    private List<RowData> videoList;


    @NonNull
    @Override
    public VideoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        return new VideoListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoListViewHolder holder, final int position) {
        holder.getVideoNameTextView().setText(videoList.get(position).getVideoName());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
    public void setVideoList(List<RowData> videoList) {
        this.videoList = videoList;
    }
}
