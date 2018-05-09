package com.example.devwill.androidvideoplayerlisttest.PlayList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.devwill.androidvideoplayerlisttest.R;
import com.example.devwill.androidvideoplayerlisttest.VideoList;
import com.example.devwill.androidvideoplayerlisttest.VideoPlayer.VideoPlayerActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements VideoListRecycleViewAdapter.VideoAdapterListener {

    private static final Pattern UNDERBAR = Pattern.compile("_", Pattern.LITERAL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        VideoListRecycleViewAdapter adapter = new VideoListRecycleViewAdapter();
        adapter.setListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.getItemAnimator().setChangeDuration(0L);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        List<Integer> idList = new ArrayList<>();
        idList.add(R.raw.five_more_minutes_please);
        idList.add(R.raw.he_came_to_work_without_his_laptop_but_he_will_not_let_anything_stand_between_him_and_productivity);
        idList.add(R.raw.hugh_jackman_runs_into_a_former_student);
        idList.add(R.raw.mans_best_friend);
        idList.add(R.raw.master_of_comedy);
        idList.add(R.raw.owner_dresses_up_as_dogs_favourite_toy);
        idList.add(R.raw.she_did_it_im_the_good_boy_so_lets_play);
        idList.add(R.raw.so_close);
        idList.add(R.raw.this_is_the_first_time_i_laughed_at_a_bull_fighting);
        idList.add(R.raw.trailer_footage_vs_actual_gameplay);
        idList.add(R.raw.wait_for_it);
        idList.add(R.raw.when_she_says_her_parents_arent_home);

        List<RowData> videoList = new ArrayList<>();
        for(int id : idList){
            videoList.add(new RowData(formatTitle(id),id));
        }
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

    private String formatTitle(int id){
        String tmp = getResources().getResourceEntryName(id);
        tmp = UNDERBAR.matcher(tmp).replaceAll(Matcher.quoteReplacement(" "));
        tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
        return tmp;
    }
}
