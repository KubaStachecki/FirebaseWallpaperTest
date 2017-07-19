package com.example.kuba_10.firebasewallpapertest;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Kuba-10 on 18.07.2017.
 */
public class ArtApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
