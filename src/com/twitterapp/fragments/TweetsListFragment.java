package com.twitterapp.fragments;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitterapp.R;
import com.twitterapp.TweetsAdapter;
import com.twitterapp.models.Tweet;

public class TweetsListFragment extends Fragment {
	TweetsAdapter tweetsAdapter;
	@Override
	public View onCreateView(LayoutInflater inf, ViewGroup parent, Bundle savedInstanceState) {
		return inf.inflate(R.layout.fragment_tweets_list, parent , false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		
		ListView lvTweets = (ListView) getActivity().findViewById(R.id.lvTweets);
		
		tweetsAdapter = new TweetsAdapter(getActivity(), tweets);
		
		lvTweets.setAdapter(tweetsAdapter);
		
	}
	
	public TweetsAdapter getAdapter() {
		return this.tweetsAdapter;
	}
}
