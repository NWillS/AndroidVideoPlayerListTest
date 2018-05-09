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

    interface VideoAdapterListener {
        void selectedVideo(int position);
    }

    private VideoAdapterListener listener;

    @NonNull
    @Override
    public VideoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new VideoListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoListViewHolder holder, final int position) {
        holder.getVideoNameTextView().setText(videoList.get(position).getVideoName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.selectedVideo(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public void setVideoList(List<RowData> videoList) {
        this.videoList = videoList;
    }

    public void setListener(VideoAdapterListener listener) {
        this.listener = listener;
    }
}
