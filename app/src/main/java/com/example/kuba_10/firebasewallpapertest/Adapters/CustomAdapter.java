//package com.example.kuba_10.firebasewallpapertest.Adapters;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
///**
// * Created by Kuba-10 on 12.07.2017.
// */
//
//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
//
//    private Context context;
//    private List<Image> data_list;
//
//    public CustomAdapter(Context context, List<Image> data_list) {
//        this.context = context;
//        this.data_list = data_list;
//
//
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//
//        //   holder.decsritption.setText(data_list.get(position).getStory());
//
////        Picasso.with(context).load(data_list.get(position).getImage()).into(holder.imageView);
//
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return data_list.size();
//    }
//
//
//
//
//
//
//    public  class ViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView decsritption;
//        public ImageView imageView;
//
//
//
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            decsritption = (TextView) itemView.findViewById(R.id.text);
//            imageView = (ImageView) itemView.findViewById(R.id.image);
//
//        }
//    }
//}
