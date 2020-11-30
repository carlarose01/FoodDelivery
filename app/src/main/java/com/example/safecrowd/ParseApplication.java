package com.example.safecrowd;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("jpyd5CaQ2R7kePIDUMzuugJ2TrU49gPJCqsriZ3p")
                .clientKey("X5hvnu4E1fLGrdUP4TQfwWNCaKge1LAoSWbw1IJI")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
