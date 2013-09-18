package com.twitterapp;

//import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.twitterapp.models.User;

public class ProfileOnImageClickListener implements OnClickListener {
	User user;
	public ProfileOnImageClickListener(User u) {
		user = u;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(v.getContext(), ProfileActivity.class);
		i.putExtra("user", user.getId());
		v.getContext().startActivity(i);
	}
}