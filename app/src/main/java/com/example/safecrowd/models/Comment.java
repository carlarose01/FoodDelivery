package com.example.safecrowd.models;

import android.util.Log;

import com.example.safecrowd.models.Post;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@ParseClassName("Comment")
public class Comment extends ParseObject {

    public static final String KEY_USER = "user";
    public static final String KEY_POST = "post";
    public static final String KEY_MESSAGE = "caption";
    public static final String KEY_PROFILEPIC = "profileImage";
    public static final String KEY_CREATEDAT = "createdAt";

    public Comment() {}

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }
    public ParseObject getCommentPost() {
        return getParseObject(KEY_POST);
    }
    public String getMessage() {
        return getString(KEY_MESSAGE);
    }
    public ParseFile getProfile() {
        return getParseUser(KEY_USER).getParseFile(KEY_PROFILEPIC);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
    public void setPost(Post post) {
        put(KEY_POST, post);
    }
    public void setMessage(String message) {
        put(KEY_MESSAGE, message);
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

}
