package com.jonikhilshi.allsync.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.jonikhilshi.allsync.Network.MyTwitterApi;
import com.jonikhilshi.allsync.Network.MyTwitterApiClient;
import com.jonikhilshi.allsync.Network.Utility;
import com.jonikhilshi.allsync.R;
import com.jonikhilshi.allsync.TwitterListsAdapter;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.TwitterApi;

public class DisplayListActivity extends AppCompatActivity {

    private RecyclerView twitterListsRView;
    private TwitterListsAdapter twitterListsAdapter;
    private MyTwitterApi twitterApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        twitterListsAdapter = new TwitterListsAdapter(this);
        twitterApi = new MyTwitterApi(TwitterCore.getInstance().getSessionManager().getActiveSession());

        twitterListsRView = findViewById(R.id.twitter_lists);
        twitterListsRView.setAdapter(twitterListsAdapter);
        twitterListsRView.setHasFixedSize(true);
        twitterListsRView.setLayoutManager(new GridLayoutManager(this, 3));

        twitterApi.getListOfTwitterList(twitterListsAdapter, Utility.LIST_SCREEN_NAME);

    }
}
