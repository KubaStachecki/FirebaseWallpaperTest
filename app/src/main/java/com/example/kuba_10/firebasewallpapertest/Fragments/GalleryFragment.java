package com.example.kuba_10.firebasewallpapertest.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.kuba_10.firebasewallpapertest.Adapters.WallAdapter;
import com.example.kuba_10.firebasewallpapertest.MainActivity;
import com.example.kuba_10.firebasewallpapertest.Model.Image;
import com.example.kuba_10.firebasewallpapertest.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {


    List<Image> imageList;
    WallAdapter wallAdapter;
    private GridLayoutManager gridManager;
    private RecyclerView recyclerView;
    private FrameLayout frameLayout;


    public GalleryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance() {
        GalleryFragment fragment = new GalleryFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        imageList = new ArrayList<>();

        frameLayout = (FrameLayout) view.findViewById(R.id.container);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        gridManager = new GridLayoutManager(getActivity(), 2);


//        recyclerView.setHasFixedSize(false);


        recyclerView.setLayoutManager(gridManager);


        wallAdapter = new WallAdapter(getActivity(), imageList);
        recyclerView.setAdapter(wallAdapter);

        getImagesFromFirebase();




        return view;
    }


    private void getImagesFromFirebase() {
        FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = fDatabase.getReference();
        databaseReference.child("wallpapers").addValueEventListener(new com.google.firebase.database.ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {


                Log.d(MainActivity.TAAAAG, Long.toString(dataSnapshot.getChildrenCount()) + "UDALO SIE POLACZYC");
                imageList.clear();


                for (com.google.firebase.database.DataSnapshot child : dataSnapshot.getChildren()) {


                    Image image = child.getValue(Image.class);

                    imageList.add(image);

                    Log.d(MainActivity.TAAAAG, imageList.size() + "ROZMIAR LISTY");

                }

                wallAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




}
