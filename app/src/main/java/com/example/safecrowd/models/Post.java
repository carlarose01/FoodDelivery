package com.example.safecrowd.models;


import android.util.Log;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_NAME = "name";
    public static final String KEY_CAPTION = "caption";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED = "createdAt";
    public static final String KEY_COMMENTS_COUNT = "commentsCount";
    public static final String KEY_LIKES_COUNT = "likesCount";
    public static final String KEY_ID = "objectId";
    public static final String KEY_PROFILEPIC = "profileImage";
    public static final String KEY_BIO = "bio";
    public static final String KEY_LIKES = "likes";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_TAG = "tag";
    private static final String TAG = "Post";
    public boolean mediaFound = true; // can set to true if image is provided

    // comments/likes count, updatedAt, location

    public Post() {}
    public String getCaption() {
        return getString(KEY_CAPTION);
    }

    public void setCaption(String caption) {
        put(KEY_CAPTION, caption);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser) {
        put(KEY_USER, parseUser);
    }

    public void setKeyLocation(ParseGeoPoint geoPoint) { put(KEY_LOCATION, geoPoint); }

    public ParseGeoPoint getKeyLocation() { return getParseGeoPoint(KEY_LOCATION); }

    public void setKeyTag(String tag) { put(KEY_TAG, tag); }

    public String getKeyTag() { return getString(KEY_TAG); }

    public int getCommentsCount() { return getInt(KEY_COMMENTS_COUNT); }

    public void setCommentsCount(int commentsCount) { put(KEY_COMMENTS_COUNT, commentsCount); }

    public int getLikesCount() { return getInt(KEY_LIKES_COUNT); }

    public void setMediaFound(boolean mediaFound) {
        this.mediaFound = mediaFound;
    }

    public boolean getMediaFound() { return mediaFound; }

    //    public void setPostLiked() {
//        if (getLikesCount() > 0) {
//            postLiked = true;
//        }
//    }

    public void setKeyId(String id) { put(KEY_ID, id); }

    public String getKeyId() { return getString(KEY_ID); }

    public ParseFile getProfile() {
        return getParseUser(KEY_USER).getParseFile(KEY_PROFILEPIC);
    }

    public String getTimestamp() {
        String createdAt = getCreatedAt().toString();
        return getSimpleDate(createdAt);
    }

    public static String getSimpleDate(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        String newFormat = "MMMM dd, yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.applyPattern(newFormat);
        String newDate = sf.format(new Date(rawJsonDate));
        Log.i("Tweet", "newDate: " + newDate);
        return newDate;
    }

    public boolean isLiked() {
        JSONArray likes = getJSONArray(KEY_LIKES);
        int size = 0;
        if (likes == null) { size = 0; } else { size = likes.length(); }
        for (int i = 0; i < size; i++) {
            String username = null;
            try {
                username = likes.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (username.equals(ParseUser.getCurrentUser().getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean addedLike() {
        boolean returnValue = true;
        Log.i(TAG, "adding like!");
        JSONArray likes = getJSONArray(KEY_LIKES);
        List<String> newLikes = new ArrayList<>();
        if (likes != null) {
            for (int i =0; i< likes.length(); i++) {
                try {
                    String username = likes.getString(i);
                    Log.i(TAG, "username: " + username + " and the current username: "  + ParseUser.getCurrentUser().getUsername());
                    if (username.equals(ParseUser.getCurrentUser().getUsername())) {
                        returnValue = false;
                    } else {
                        newLikes.add(username);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (returnValue) {
            newLikes.add(ParseUser.getCurrentUser().getUsername());
        }
        put(KEY_LIKES, newLikes);
        return returnValue;

    }

    public int getLikeNum() {
        JSONArray likes = getJSONArray(KEY_LIKES);
        if (likes != null) {
            return likes.length();
        } else {
            return 0;
        }
    }


}

