package com.jonikhilshi.allsync;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class TwitterListsAdapter extends RecyclerView.Adapter<TwitterListsAdapter.TwitterListsViewHolder> {

    @NonNull
    @Override
    public TwitterListsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TwitterListsViewHolder twitterListsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TwitterListsViewHolder  extends RecyclerView.ViewHolder {

        public TwitterListsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
