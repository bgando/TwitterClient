package com.twitterapp;

import java.util.ArrayList;

import org.json.JSONArray;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.twitterapp.models.Tweet;

public class TimelineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        TwitterApp.getRestClient().getHomeFeed(new JsonHttpResponseHandler(){
        	public void onSuccess(JSONArray jsonTweets){
        		ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
        		
        		ListView lvTweets = (ListView) findViewById(R.id.lvTweets);
        		
        		TweetsAdapter adapter = new TweetsAdapter(getBaseContext(), tweets);
        		
        		lvTweets.setAdapter(adapter);
        	}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timeline, menu);
        return true;
    }
    
}
