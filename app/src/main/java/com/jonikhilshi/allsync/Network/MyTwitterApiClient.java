package com.jonikhilshi.allsync.Network;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Extension of the Twitter API client to get lists
 */
public class MyTwitterApiClient extends TwitterApiClient {

    public MyTwitterApiClient(TwitterSession session){
        super(session);
    }

    public TwitterListsService getListsService() {
        return (TwitterListsService) this.getService(TwitterListsService.class);
    }
}
