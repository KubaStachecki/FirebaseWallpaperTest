package com.example.kuba_10.firebasewallpapertest;

import android.app.ActionBar;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.kuba_10.firebasewallpapertest.Adapters.WallAdapter;
import com.example.kuba_10.firebasewallpapertest.Fragments.FragmentUtils;
import com.example.kuba_10.firebasewallpapertest.Fragments.GalleryFragment;
import com.example.kuba_10.firebasewallpapertest.Fragments.SplashFragment;
import com.example.kuba_10.firebasewallpapertest.Model.Image;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentUtils {


    public static final String TAAAAG = "TAAAAG";

    private static final int REQUEST_WRITE_PERMISSION = 786;


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        }
    }


    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();


        requestPermission();

        SplashFragment.newInstance().show(getSupportFragmentManager(), "");



        openFragment(GalleryFragment.newInstance());



    }





    @Override
    protected void onResume() {
        super.onResume();


        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        getSupportActionBar().hide();
    }

    @Override
    public void openFragment(Fragment fragment) {

        this.getSupportFragmentManager()
                .beginTransaction()
//                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.main_container, fragment)
                .addToBackStack(null)
                .commit();
    }


//        File file = new File(this.getFilesDir(), "/kuuuuba");
//
//        if (!file.exists()) {
//            if (file.mkdir()) ; //directory is created;
//
//            Toast.makeText(this, "zrobilem folder!", Toast.LENGTH_SHORT).show();
//
//        }
//
//        Toast.makeText(this, "folder juz byl", Toast.LENGTH_SHORT).show();


}



