package com.example.devwill.androidvideoplayerlisttest.PlayList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.devwill.androidvideoplayerlisttest.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VideoListRecycleViewAdapter adapter;
    private List<RowData> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new VideoListRecycleViewAdapter();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.getItemAnimator().setChangeDuration(0);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        videoList = new ArrayList<>();
        videoList.add(new RowData("Five more minutes please",1));
        videoList.add(new RowData("He came to work without his laptop but he will not let anything stand between him and productivity",2));
        videoList.add(new RowData("Hugh jackman runs into a former student",3));
        videoList.add(new RowData("Mans best friend",4));
        videoList.add(new RowData("Master of comedy",5));
        videoList.add(new RowData("Owner dresses up as dogs favourite toy",6));
        videoList.add(new RowData("She did it im the good boy so lets play",7));
        videoList.add(new RowData("So close",8));
        videoList.add(new RowData("This is the first time i laughed at a bull",9));
        videoList.add(new RowData("Trailer footage vs actual gameplay",10));
        videoList.add(new RowData("Wait for it",11));
        videoList.add(new RowData("When she says her parents arent home",12));
        adapter.setVideoList(videoList);
        adapter.notifyDataSetChanged();


    }
}
