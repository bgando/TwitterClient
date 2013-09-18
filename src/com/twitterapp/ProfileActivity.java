package com.twitterapp;

import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.twitterapp.models.User;

public class ProfileActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		loadProfileInfo();
		
	}
	
    public void loadProfileInfo() {

    	if (getIntent().getExtras() != null) {
            long user = getIntent().getExtras().getLong("user");  
            TwitterApp.getRestClient().getUserInfo( user,
            		new JsonHttpResponseHandler() {
            			@Override
            			public void onSuccess(JSONObject obj) {
            				User u = User.fromJson(obj);
            				getActionBar().setTitle("@" + u.getScreenName());
            				populateProfileHeader(u);
            			}


            		});
        } else {

    	
    	TwitterApp.getRestClient().getMyInfo(
        		new JsonHttpResponseHandler() {
        			@Override
        			public void onSuccess(JSONObject obj) {
        				User u = User.fromJson(obj);
        				getActionBar().setTitle("@" + u.getScreenName());
        				populateProfileHeader(u);
        			}


        		});
        }
    	
		
	}
	public void populateProfileHeader(User user) {
		TextView tvName = (TextView) findViewById(R.id.tvName);
		TextView tvTagLine = (TextView) findViewById(R.id.tvTagLine);
		TextView tvFollowers = (TextView) findViewById(R.id.tvFollowers);
		TextView tvFollowing = (TextView) findViewById(R.id.tvFollowing);
		ImageView ivProfile = (ImageView) findViewById(R.id.ivProfileImage);
		
		tvName.setText(user.getName());
		tvTagLine.setText(user.getTagline());
		tvFollowers.setText(user.getFollowersCount() + " Followers");
		tvFollowing.setText(user.getFriendsCount() + " Following");
		ImageLoader.getInstance().displayImage(user.getProfileImageUrl(), ivProfile);
		
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
