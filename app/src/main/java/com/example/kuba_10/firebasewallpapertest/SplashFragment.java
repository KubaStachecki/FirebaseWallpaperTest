package com.example.kuba_10.firebasewallpapertest;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kuba_10.firebasewallpapertest.Model.Image;

import java.util.List;


public class SplashFragment extends DialogFragment {

    List<Image> list;


    private final int SPLASH_TIME_OUT = 5000;


    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setLayout(width, height);


    }

    public static SplashFragment newInstance() {


        SplashFragment fragment = new SplashFragment();





        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // realnie pelen ekran ?

   //     setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);


        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                dismiss();

        }};


        handler.postDelayed(runnable, SPLASH_TIME_OUT);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        this.setCancelable(false);
    }


}
