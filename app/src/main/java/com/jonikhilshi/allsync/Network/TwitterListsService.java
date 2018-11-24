package com.jonikhilshi.allsync.Network;

import com.jonikhilshi.allsync.TwitterListInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit class to retrieve lists
 */
public interface TwitterListsService {

    @GET("/1.1/lists/list.json")
    Call<List<TwitterListInfo>> listOfTwitterList(@Query("screen_name") String screenName);

}
