package com.jonikhilshi.allsync.UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.GridView;
import android.widget.Toast;

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

        getSupportActionBar().setTitle(R.string.spaces);

        setContentView(R.layout.activity_display_list);

        twitterListsAdapter = new TwitterListsAdapter(this);
        twitterApi = new MyTwitterApi(TwitterCore.getInstance().getSessionManager().getActiveSession());

        twitterListsRView = findViewById(R.id.twitter_lists);
        twitterListsRView.setAdapter(twitterListsAdapter);
        twitterListsRView.setHasFixedSize(true);
        twitterListsRView.setLayoutManager(new GridLayoutManager(this, 3));

        twitterApi.getListOfTwitterList(twitterListsAdapter, Utility.LIST_SCREEN_NAME);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.display_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicked = item.getItemId();
        if (itemClicked == R.id.logout_menu_item) {
            AlertDialog.Builder builder = new AlertDialog.Builder(DisplayListActivity.this);
            builder.setMessage(getString(R.string.verify_user_wants_to_logout))
                    .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                                CookieManager.getInstance().removeAllCookies(null);
                                CookieManager.getInstance().flush();

                            } else {
                                CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(getApplicationContext());
                                cookieSyncMngr.startSync();
                                CookieManager cookieManager = CookieManager.getInstance();
                                cookieManager.removeAllCookie();
                                cookieManager.removeSessionCookie();
                                cookieSyncMngr.stopSync();
                                cookieSyncMngr.sync();
                            }


                            Intent intent = new Intent(getApplication(), LoginActivity.class);
                            startActivity(intent);
                        }
                    });
            builder.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
