package com.example.kuba_10.firebasewallpapertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kuba_10.firebasewallpapertest.Model.Image;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Image> imageList;
    WallAdapter wallAdapter;
    private GridLayoutManager gridManager;
    private RecyclerView recyclerView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        gridManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridManager);

        wallAdapter = new WallAdapter(this, imageList);
        recyclerView.setAdapter(wallAdapter);


        getImagesFromFirebase();


    }









    private void getImagesFromFirebase() {
        FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = fDatabase.getReference();
        databaseReference.child("wallpapers").addValueEventListener(new com.google.firebase.database.ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {


                Log.d("TAAAAG",Long.toString(dataSnapshot.getChildrenCount()) + "UDALO SIE POLACZYC");
                imageList.clear();


                for (com.google.firebase.database.DataSnapshot child : dataSnapshot.getChildren()) {


                    Image image = child.getValue(Image.class);

                    imageList.add(image);

                    Log.d("TAAAAG",imageList.size() + "ROZMIAR LISTY");

                }

                wallAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
