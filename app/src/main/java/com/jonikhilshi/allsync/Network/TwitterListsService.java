package com.jonikhilshi.allsync.Network;

import com.jonikhilshi.allsync.TwitterListInfo;
import com.jonikhilshi.allsync.TwtrListInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterListsService {

    @GET("/1.1/lists/list.json")
    Call<List<TwitterListInfo>> listOfTwitterList(@Query("screen_name") String screenName);

}
