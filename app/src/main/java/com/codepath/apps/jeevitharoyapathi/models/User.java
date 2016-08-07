package com.codepath.apps.jeevitharoyapathi.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jeevitha.royapathi on 8/4/16.
 */
public class User {

    private long id;
    private String name;
    private String screenName;
    private String profileImageUrl;
    private int followersCount;
    private String description;
    private String profileBackgroundImageUrl;
    private int friendsCount;
    private boolean following;

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

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
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