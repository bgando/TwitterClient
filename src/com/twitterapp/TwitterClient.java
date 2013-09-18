package com.twitterapp;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
    public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
    public static final String REST_CONSUMER_KEY = "vjZX0sAUkY2TyIYVqHLA";       // Change this
    public static final String REST_CONSUMER_SECRET = "f3J9OreZSwX4JzHQzMDveMVuXH1VwthxRDqeeQ94"; // Change this
    public static final String REST_CALLBACK_URL = "oauth://twitterapp"; // Change this (here and in manifest)
    
    public TwitterClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }
    
    // CHANGE THIS
    // DEFINE METHODS for different API endpoints here
    public void getHomeFeed(JsonHttpResponseHandler handler){
    	String apiUrl = getApiUrl("statuses/home_timeline.json");
    	client.get(apiUrl, null, handler);
    }
    
    public void getMentions(JsonHttpResponseHandler handler){
    	String apiUrl = getApiUrl("statuses/mentions_timeline.json");
    	client.get(apiUrl, null, handler);
    }
    
    public void postTweet(JsonHttpResponseHandler handler, String text){
    	String apiUrl = getApiUrl("statuses/update.json");
    	RequestParams params = new RequestParams("status", text);
    	client.post(apiUrl, params, handler);
    }

    public void getMyInfo(JsonHttpResponseHandler handler){
    	String apiUrl = getApiUrl("account/verify_credentials.json");
    	client.get(apiUrl, null, handler);
    	
    	
    };
    
    public void getUserInfo(long userId, JsonHttpResponseHandler handler){
    	RequestParams params = new RequestParams();
    	String id = String.valueOf(userId);
    	params.put("user_id", id);
    	String apiUrl = getApiUrl("users/show.json");
    	client.get(apiUrl, params, handler);
    }
    
    public void getNewUserTimeline(long userId, JsonHttpResponseHandler handler){
    	RequestParams params = new RequestParams();
    	String id = String.valueOf(userId);
    	params.put("user_id", id);
    	String apiUrl = getApiUrl("statuses/user_timeline.json");
    	client.get(apiUrl, params, handler);
    }

    public void getUserTimeline(JsonHttpResponseHandler handler){
    	String apiUrl = getApiUrl("statuses/user_timeline.json");
    	client.get(apiUrl, null, handler);
    };

}