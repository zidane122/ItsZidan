package com.example.itszidan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    Context context;
    ArrayList<Gallery> galleryArrayList;

    public GalleryAdapter(Context context, ArrayList<Gallery> galleryArrayList) {
        this.context = context;
        this.galleryArrayList = galleryArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.gallery_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Gallery gallery = galleryArrayList.get(position);
        holder.textImage.setText(gallery.textImage);
        holder.titleImage.setImageResource(gallery.titleImage);
    }

    @Override
    public int getItemCount() {
        return galleryArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ShapeableImageView titleImage;
        TextView textImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            textImage = itemView.findViewById(R.id.text_image);
        }
    }
}
