package com.example.devwill.androidvideoplayerlisttest.PlayList;

class RowData {
    private final String videoName;
    private final int id;
    private boolean playing;

    public RowData(String videoName, int id) {
        this.videoName = videoName;
        this.id = id;
        playing = false;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public int getId() {
        return this.id;
    }

    public boolean isPlaying() {
        return this.playing;
    }
}
