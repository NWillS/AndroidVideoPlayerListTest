package com.example.devwill.androidvideoplayerlisttest;

import com.example.devwill.androidvideoplayerlisttest.PlayList.RowData;

import java.util.List;

public class VideoList {
    private static List<RowData> list;

    public static List<RowData> getList() {
        return list;
    }

    public static void setList(List<RowData> list) {
        VideoList.list = list;
    }
}
