package com.jonikhilshi.allsync.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jonikhilshi.allsync.Network.Utility;
import com.jonikhilshi.allsync.R;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.TwitterListTimeline;

public class ListTimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String listName = getIntent().getStringExtra(Utility.LIST_NAME);
        getSupportActionBar().setTitle(listName);

        setContentView(R.layout.activity_list_timeline);

        final RecyclerView listTimelineRecyclerView = findViewById(R.id.list_timeline_recycler_view);
        listTimelineRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final String slugName = getIntent().getStringExtra(Utility.SLUG_NAME_TAG);
        final TwitterListTimeline listTimeline = new TwitterListTimeline.Builder()
                .slugWithOwnerScreenName(slugName, "allsync1")
                .build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(this)
                        .setTimeline(listTimeline)
                        .setViewStyle(R.style.tw__TweetDarkStyle)
                        .build();

        listTimelineRecyclerView.setAdapter(adapter);

    }

}
