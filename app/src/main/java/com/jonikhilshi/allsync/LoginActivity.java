package com.jonikhilshi.allsync;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Logger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity {


    private TwitterLoginButton loginButton = null;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .debug(true)
                .build();

        Twitter.initialize(config);

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);

        Callback<TwitterSession> loginCallback = new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                Log.i(TAG, "Login completed successfully!! token: " + token + " secret: " + secret);
//                Toast.makeText(getApplicationContext(), "token: " + token + " secret: " + secret, Toast.LENGTH_LONG);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.e(TAG, "Wasn't able to login successfully");

            }
        };

        loginButton.setCallback(loginCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
