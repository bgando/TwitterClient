package com.twitterapp.fragments;

import java.util.ArrayList;

import org.json.JSONArray;

import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.twitterapp.R;
import com.twitterapp.TwitterApp;
import com.twitterapp.models.Tweet;

public class UserTimelineFragment extends TweetsListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		final TweetsListFragment fragmentTweets;
		super.onCreate(savedInstanceState);
		
		fragmentTweets = (TweetsListFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentUserTimeline);

        TwitterApp.getRestClient().getUserTimeline(new JsonHttpResponseHandler(){
        	public void onSuccess(JSONArray jsonTweets){
        		ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets); 
        		fragmentTweets.getAdapter().addAll(tweets);

        	}
        	
			public void onFailure(Throwable error) {
				Log.d("Debug", "NOOO request failed.");
				Log.d("Debug", error.getMessage());
			}
        });
	}
}
