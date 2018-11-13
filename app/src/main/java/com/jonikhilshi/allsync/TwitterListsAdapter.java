package com.jonikhilshi.allsync;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TwitterListsAdapter extends RecyclerView.Adapter<TwitterListsAdapter.TwitterListViewHolder> {

    private Context mContext;

    public TwitterListsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public TwitterListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View twitterListItem = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.twitter_list_item, parent, false
        );

        TwitterListViewHolder twitterListViewHolder = new TwitterListViewHolder(twitterListItem);

        return twitterListViewHolder;
    }

    @Override
    public void onBindViewHolder(TwitterListViewHolder twitterListsViewHolder, int i) {
        String listName = "Product Management";
        twitterListsViewHolder.bindView(listName);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class TwitterListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView twitterListItemName;

        public TwitterListViewHolder(View twitterListItem) {
            super(twitterListItem);
            twitterListItem.setOnClickListener(this);
            twitterListItemName = twitterListItem.findViewById(R.id.twitter_list_item_name);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, ListTimelineActivity.class);
            mContext.startActivity(intent);
        }

        public void bindView(String listName) {
            twitterListItemName.setText(listName);
        }
    }
}
