package com.twitterapp.models;

import org.json.JSONObject;

public class User extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getName() {
        return getString("name");
    }

    public long getId() {
        return getLong("id");
    }

    public String getScreenName() {
        return getString("screen_name");
    }

    public String getProfileImageUrl() {
        return getString("profile_image_url");
    }

    public String getProfileBackgroundImageUrl() {
        return getString("profile_background_image_url");
    }

    public int getNumTweets() {
        return getInt("statuses_count");
    }

    public int getFollowersCount() {
        return getInt("followers_count");
    }

    public int getFriendsCount() {
        return getInt("friends_count");
    }
    
    public String getTagline() {
    	return getString("description");
    }

    public static User fromJson(JSONObject json) {
        User u = new User();

        try {
            u.jsonObject = json;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }


}
