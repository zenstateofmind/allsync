package com.jonikhilshi.allsync;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jonikhilshi.allsync.Network.Utility;
import com.jonikhilshi.allsync.UI.ListTimelineActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the adapter that captures the list of TwitterListInfo and goes through them to surface
 * on a recycler view
 */
public class TwitterListsAdapter extends RecyclerView.Adapter<TwitterListsAdapter.TwitterListViewHolder> {

    public final static String LOG_TAG = TwitterListsAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<TwitterListInfo> twitterLists;

    public TwitterListsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public TwitterListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View twitterListItem = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.twitter_list_item, parent, false
        );

        int height = parent.getMeasuredHeight()/4;
        twitterListItem.setMinimumHeight(height);

        TwitterListViewHolder twitterListViewHolder = new TwitterListViewHolder(twitterListItem);

        return twitterListViewHolder;
    }

    @Override
    public void onBindViewHolder(TwitterListViewHolder twitterListsViewHolder, int position) {
        if(twitterLists != null && twitterLists.size() > position) {
            TwitterListInfo twitterListInfo = twitterLists.get(position);
            twitterListsViewHolder.bindInfo(twitterListInfo);
        }

    }

    public void addTwitterLists(List<TwitterListInfo> twitterListInfos) {
        if (twitterLists == null) {
            twitterLists = new ArrayList<>();
        }
        twitterLists.addAll(twitterListInfos);
        Log.i(LOG_TAG, "The number of lists that have been added are: " + twitterListInfos.size());

        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return twitterLists != null ? twitterLists.size() : 0;
    }

    public class TwitterListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView twitterListItemName;
        private TwitterListInfo twitterListInfo;

        public TwitterListViewHolder(View twitterListItem) {
            super(twitterListItem);
            twitterListItem.setOnClickListener(this);
            twitterListItemName = twitterListItem.findViewById(R.id.twitter_list_item_name);
        }

        @Override
        public void onClick(View v) {
            if (twitterListInfo != null) {
                Intent intent = new Intent(mContext, ListTimelineActivity.class);
                intent.putExtra(Utility.SLUG_NAME_TAG, twitterListInfo.slug);
                intent.putExtra(Utility.LIST_NAME, twitterListInfo.name);
                mContext.startActivity(intent);
            }
        }

        public void bindInfo(TwitterListInfo twitterListInfo) {
            this.twitterListInfo = twitterListInfo;
            twitterListItemName.setText(twitterListInfo.name);
        }
    }
}
