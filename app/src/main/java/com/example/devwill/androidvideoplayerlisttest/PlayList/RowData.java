package com.example.devwill.androidvideoplayerlisttest.PlayList;

public class RowData {
    private final String videoName;
    private final int id;

    RowData(String videoName, int id) {
        this.videoName = videoName;
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public int getId() {
        return id;
    }
}
