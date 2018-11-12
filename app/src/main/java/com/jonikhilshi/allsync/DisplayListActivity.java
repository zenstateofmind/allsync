package com.jonikhilshi.allsync;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DisplayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        RecyclerView twitterListsRView = findViewById(R.id.twitter_lists);
        twitterListsRView.setLayoutManager(new LinearLayoutManager(this));


    }
}
