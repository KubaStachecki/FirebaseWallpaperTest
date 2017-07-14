package com.example.kuba_10.firebasewallpapertest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kuba_10.firebasewallpapertest.Model.Image;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageFragment extends Fragment {

    @BindView(R.id.big_image)
    ImageView bigImage;

    @BindView(R.id.save_btn)
    AppCompatButton saveBtn;

    @BindView(R.id.share_btn)
    AppCompatButton shareBtn;


    @BindView(R.id.set_btn)
    AppCompatButton setBtn;


    Bundle bundle;
    Utils utils;


    public ImageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(Bundle bundle) {
        ImageFragment fragment = new ImageFragment();

        fragment.setArguments(bundle);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainActivity) getActivity()).getSupportActionBar().hide();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        ButterKnife.bind(this, view);

        Image image = getArguments().getParcelable("Image");

        Picasso.with(getActivity()).load(image.getUrl())

                .resize(800, 800)
                .centerCrop()
                .into(bigImage);

        image.getUrl();

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        utils = new Utils(getActivity());


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "save", Toast.LENGTH_SHORT).show();

//                bigImage.setDrawingCacheEnabled(true);
//
//                bigImage.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//                bigImage.layout(0, 0, bigImage.getMeasuredWidth(), bigImage.getMeasuredHeight());
//
//                bigImage.buildDrawingCache(true);
//                Bitmap bitmap = Bitmap.createBitmap(bigImage.getDrawingCache());
//                bigImage.setDrawingCacheEnabled(false); // clear drawing cache


//
//                utils.saveImageToSDCard(bitmap);

                Bitmap bm2 = ((BitmapDrawable)bigImage.getDrawable()).getBitmap();

                utils.saveImageToSDCard(bm2);

            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "share", Toast.LENGTH_SHORT).show();


            }
        });

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "set", Toast.LENGTH_SHORT).show();

                Bitmap bm3 = ((BitmapDrawable)bigImage.getDrawable()).getBitmap();

               utils.setAsWallpaper(bm3);

            }
        });


    }
}