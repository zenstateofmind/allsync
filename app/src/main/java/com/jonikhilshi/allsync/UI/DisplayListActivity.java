package com.jonikhilshi.allsync.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jonikhilshi.allsync.R;
import com.jonikhilshi.allsync.TwitterListsAdapter;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;

public class DisplayListActivity extends AppCompatActivity {

    private RecyclerView twitterListsRView;
    private TwitterListsAdapter twitterListsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        twitterListsAdapter = new TwitterListsAdapter(this);

        twitterListsRView = findViewById(R.id.twitter_lists);
        twitterListsRView.setAdapter(twitterListsAdapter);
        twitterListsRView.setHasFixedSize(true);
        twitterListsRView.setLayoutManager(new LinearLayoutManager(this));

        // Need to push something in to make sure that I don't lose the habit
    }
}
