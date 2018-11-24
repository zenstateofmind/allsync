package com.jonikhilshi.allsync.Network;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Capturing all the constants
 */
public class Utility {

    public static final String LIST_NAME = "list_name";
    final static String TWITTER_BASE_URL =
            "https://api.twitter.com/1.1/lists/statuses.json";

    public static final String LIST_SCREEN_NAME = "allsync1";
    public static final String SLUG_NAME_TAG = "slug_id";

    final static String PARAM_QUERY = "q";

    /*
     * The sort field. One of stars, forks, or updated.
     * Default: results are sorted by best match if no field is specified.
     */
    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";

    final static String SLUG_QUERY = "slug";
    final static String OWNER_SCREEN_NAME = "owner_screen_name";

    //Create the URL
    public static URL createHttpUrl(String githubSearchQuery) {

        Uri builtUri = Uri.parse(TWITTER_BASE_URL).buildUpon()
                .appendQueryParameter(SLUG_QUERY, "product-management")
                .appendQueryParameter(OWNER_SCREEN_NAME, "allsync1")
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * Use the conventional HttpURLConnection methodology to get data from an http connection
     * @param url
     * @return
     * @throws IOException
     */
    public static String getResponseFromHttp(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    /**
     * Use OkHttpClient to get data from an http connection
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String getResponseFromOkHttp(URL url) throws IOException {


        OkHttpOAuthConsumer oauthHeader = new OkHttpOAuthConsumer("",
                "");

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new SigningInterceptor(oauthHeader)).build();

        Request request = new Request.Builder().url(url.toString()).build();
        Response response = client.newCall(request).execute();

        return "changed text" + response.body().string();
    }

}
