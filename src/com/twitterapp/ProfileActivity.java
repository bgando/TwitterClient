package com.twitterapp;

import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.twitterapp.models.User;

public class ProfileActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		loadProfileInfo();
		
	}
	
    private void loadProfileInfo() {
    	TwitterApp.getRestClient().getMyInfo(
        		new JsonHttpResponseHandler() {
        			@Override
        			public void onSuccess(JSONObject obj) {
        				User u = User.fromJson(obj);
        				getActionBar().setTitle("@" + u.getScreenName());
        			}
        		});
    	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
