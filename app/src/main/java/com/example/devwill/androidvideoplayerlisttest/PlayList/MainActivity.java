package com.example.devwill.androidvideoplayerlisttest.PlayList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.devwill.androidvideoplayerlisttest.R;
import com.example.devwill.androidvideoplayerlisttest.VideoList;
import com.example.devwill.androidvideoplayerlisttest.VideoPlayer.VideoPlayerActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VideoListRecycleViewAdapter.VideoAdapterListener {
    private VideoListRecycleViewAdapter adapter;
    private List<RowData> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new VideoListRecycleViewAdapter();
        adapter.setListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.getItemAnimator().setChangeDuration(0);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        videoList = new ArrayList<>();
        videoList.add(new RowData("Five more minutes please",R.raw.five_more_minutes_please));
        videoList.add(new RowData("He came to work without his laptop but he will not let anything stand between him and productivity",
                R.raw.he_came_to_work_without_his_laptop_but_he_will_not_let_anything_stand_between_him_and_productivity));
        videoList.add(new RowData("Hugh jackman runs into a former student",R.raw.hugh_jackman_runs_into_a_former_student));
        videoList.add(new RowData("Mans best friend",R.raw.mans_best_friend));
        videoList.add(new RowData("Master of comedy",R.raw.master_of_comedy));
        videoList.add(new RowData("Owner dresses up as dogs favourite toy",R.raw.owner_dresses_up_as_dogs_favourite_toy));
        videoList.add(new RowData("She did it im the good boy so lets play",R.raw.she_did_it_im_the_good_boy_so_lets_play));
        videoList.add(new RowData("So close",R.raw.so_close));
        videoList.add(new RowData("This is the first time i laughed at a bull",R.raw.this_is_the_first_time_i_laughed_at_a_bull_fighting));
        videoList.add(new RowData("Trailer footage vs actual gameplay",R.raw.trailer_footage_vs_actual_gameplay));
        videoList.add(new RowData("Wait for it",R.raw.wait_for_it));
        videoList.add(new RowData("When she says her parents arent home",R.raw.when_she_says_her_parents_arent_home));
        VideoList.setList(videoList);
        adapter.setVideoList(videoList);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void selectedVideo(int position) {
        Intent intent = new Intent(getApplication(), VideoPlayerActivity.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
