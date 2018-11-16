package com.jonikhilshi.allsync.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jonikhilshi.allsync.R;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.TwitterListTimeline;

public class ListTimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_timeline);

        final RecyclerView listTimelineRecyclerView = findViewById(R.id.list_timeline_recycler_view);
        listTimelineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TwitterListTimeline listTimeline = new TwitterListTimeline.Builder()
                .slugWithOwnerScreenName("product-management", "allsync1")
                .build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(this)
                        .setTimeline(listTimeline)
                        .setViewStyle(R.style.tw__TweetDarkStyle)
                        .build();

        listTimelineRecyclerView.setAdapter(adapter);

    }

}
