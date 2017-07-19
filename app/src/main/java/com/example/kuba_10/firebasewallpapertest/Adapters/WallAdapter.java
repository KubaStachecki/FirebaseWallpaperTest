package com.example.kuba_10.firebasewallpapertest.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kuba_10.firebasewallpapertest.Fragments.FragmentUtils;
import com.example.kuba_10.firebasewallpapertest.Fragments.ImageFragment;
import com.example.kuba_10.firebasewallpapertest.Model.Image;
import com.example.kuba_10.firebasewallpapertest.R;
import com.example.kuba_10.firebasewallpapertest.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kuba-10 on 13.07.2017.
 */
public class WallAdapter extends RecyclerView.Adapter<WallAdapter.ViewHolder> {

    private int imageSizePixelsW;
    private int imageSizePixelsH;
    private Context context;
    private List<Image> data_list;
    private FragmentUtils fragmentUtils;
    Utils utils;


    public WallAdapter(Context context, List<Image> data_list) {
        this.context = context;
        this.data_list = data_list;


        imageSizePixelsW = context.getResources().getDimensionPixelSize(R.dimen.card_image_width);
        imageSizePixelsH = context.getResources().getDimensionPixelSize(R.dimen.card_image_heigth);

        fragmentUtils = (FragmentUtils) context;

        utils = new Utils(context);


    }


    @Override
    public WallAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(WallAdapter.ViewHolder holder, final int position) {




        Picasso.with(context).load(data_list.get(position).getUrl())
                .resize((utils.getScreenWidth()/2)-20, (utils.getScreenWidth()/2)-20)

                .centerCrop()

//                .placeholder(R.drawable.progress_animation)
                .into(holder.imageView);

        holder.artist.setText(data_list.get(position).getArtist());
        holder.comment.setText(data_list.get(position).getComment());


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putParcelable("Image", data_list.get(position));

                fragmentUtils.openFragment(ImageFragment.newInstance(bundle));


//                Toast.makeText(context, "klik", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView artist;
        public TextView comment;
        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            artist = (TextView) itemView.findViewById(R.id.artist);
            comment = (TextView) itemView.findViewById(R.id.comment);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}