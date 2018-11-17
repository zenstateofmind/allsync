package com.jonikhilshi.allsync.Network;

import android.os.AsyncTask;
import android.util.Log;

import com.jonikhilshi.allsync.TwitterListInfo;
import com.jonikhilshi.allsync.TwitterListsAdapter;
import com.twitter.sdk.android.core.TwitterSession;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTwitterApi {

    private static final String LOG_TAG = MyTwitterApi.class.getSimpleName();
    final MyTwitterApiClient myTwitterApiClient;

    public MyTwitterApi(TwitterSession twitterSession) {
        myTwitterApiClient = new MyTwitterApiClient(twitterSession);

    }

    public void getListOfTwitterList(final TwitterListsAdapter listsAdapter, final String screenName) {

        Call<List<TwitterListInfo>> call = myTwitterApiClient.getListsService().listOfTwitterList(screenName);

        call.enqueue(new Callback<List<TwitterListInfo>>() {
            @Override
            public void onResponse(Call<List<TwitterListInfo>> call, Response<List<TwitterListInfo>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<TwitterListInfo> twitterLists = response.body();
                listsAdapter.addTwitterLists(twitterLists);
            }

            @Override
            public void onFailure(Call<List<TwitterListInfo>> call, Throwable t) {
                Log.e(LOG_TAG, "Not able to retrieve the list of twitter lists that belong to to the user: " + screenName + " because of error: " + t.getMessage());
            }
        });


    }

}
