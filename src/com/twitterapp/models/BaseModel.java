package com.twitterapp.models;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

//lightweight JSON model in Java
public class BaseModel implements Serializable {
	private static final long serialVersionUID = -5529838360399843731L;
	protected JSONObject jsonObject;

	public String getJSONString() {
		return getJsonObject().toString();
	}

	protected String getString(String name) {
		try {
			return getJsonObject().getString(name);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected long getLong(String name) {
		try {
			return getJsonObject().getLong(name);
		} catch (JSONException e) {
			e.printStackTrace();
			return 0;
		}
	}

	protected int getInt(String name) {
		try {
			return getJsonObject().getInt(name);
		} catch (JSONException e) {
			e.printStackTrace();
			return 0;
		}
	}

	protected double getDouble(String name) {
		try {
			return getJsonObject().getDouble(name);
		} catch (JSONException e) {
			e.printStackTrace();
			return 0;
		}
	}

	protected boolean getBoolean(String name) {
		try {
			return getJsonObject().getBoolean(name);
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
}