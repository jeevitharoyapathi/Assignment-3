package com.codepath.apps.jeevitharoyapathi.models;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

/**
 * Created by jeevitha.royapathi on 8/4/16.
 */
@Parcel
public class User {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("profile_image_url")
    private String profileImageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public static User fromJSON(JSONObject jsonObject) {
        User user = new User();
        try {
            user.setName(jsonObject.getString("name"));
            user.setId(jsonObject.getLong("id"));
            user.setScreenName(jsonObject.getString("screen_name"));
            user.setProfileImageUrl(jsonObject.getString("profile_image_url"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;

    }
}