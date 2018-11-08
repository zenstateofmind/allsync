package com.jonikhilshi.allsync;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jonikhilshi.allsync.utility.Utility;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView showResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResults = findViewById(R.id.show_results);

        URL sampleUrl = Utility.createHttpUrl("tennis");

        // Call the asynctask so that we run on a separate thread
        new RunGithubTask().execute(sampleUrl);
    }


    /**
     * AsyncTask that takes in a url, does a get call and returns the json response
     */
    public class RunGithubTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            URL searchUrl = urls[0];
            String searchResponse = null;

            try {
                searchResponse = Utility.getResponseFromHttp(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.equals("")) {
                showResults.setText(s);
            }
        }
    }
}
