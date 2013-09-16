package com.twitterapp;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.twitterapp.fragments.HomeTimelineFragment;
import com.twitterapp.fragments.MentionsFragment;
import com.twitterapp.models.Tweet;
import com.twitterapp.models.TweetData;
import com.twitterapp.models.User;

public class TimelineActivity extends FragmentActivity implements TabListener {
	private TweetsAdapter tweetsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        setupNavigationTabs();
    }
    
    private void setupNavigationTabs() {
    	ActionBar actionBar = getActionBar();
    	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    	actionBar.setDisplayShowTitleEnabled(true);
    	Tab tabHome = actionBar.newTab().setText("Home")
    			.setTag("HomeTimelineFragment")
    			.setIcon(R.drawable.ic_home)
    			.setTabListener(this);
    	
    	Tab tabMentions = actionBar.newTab().setText("Mentions")
    			.setTag("MentionsFragment")
    			.setIcon(R.drawable.ic_mentions)
    			.setTabListener(this);
    	
    	actionBar.addTab(tabHome);
    	actionBar.addTab(tabMentions);
    	actionBar.selectTab(tabHome);
	}

	public void onCompose(MenuItem mi){
    	
    	Intent i = new Intent(getBaseContext(), ComposeActivity.class);
    	startActivityForResult(i, 10);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timeline, menu);
        return true;
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	Toast.makeText(getApplicationContext(), "onActivityResult", Toast.LENGTH_SHORT).show();
		if (resultCode == RESULT_OK && requestCode == 10) {
			TweetData tweetData = (TweetData) data
					.getSerializableExtra("TweetData");

			Tweet tweet = new Tweet();
			User user = new User();
			JSONObject tweetAsJson;
			JSONObject userAsjson;
			try {
				tweetAsJson = new JSONObject(tweetData.getJsonString());
				tweet.setJsonObject(tweetAsJson);
				userAsjson = new JSONObject(tweetData.getUserString());
				user.setJsonObject(userAsjson);
				tweet.setUser(user);
				tweetsAdapter.insert(tweet, 0);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = manager.beginTransaction();
		if(tab.getTag() == "HomeTimelineFragment"){
			fts.replace(R.id.frameLayout, new HomeTimelineFragment());
			
		} else {
			fts.replace(R.id.frameLayout, new MentionsFragment());
		}
		
		fts.commit();
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
    
}
