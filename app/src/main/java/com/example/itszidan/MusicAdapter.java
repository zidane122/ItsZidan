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

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder>{
    Context context;
    ArrayList<Music> musicArrayList;

    public MusicAdapter(Context context, ArrayList<Music> musicArrayList) {
        this.context = context;
        this.musicArrayList = musicArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.music_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Music music = musicArrayList.get(position);

        holder.musicTitle.setText(music.musicTitle);
        holder.titleImage.setImageResource(music.titleImage);
        holder.musicArtist.setText(music.musicArtist);
    }

    @Override
    public int getItemCount() {
        return musicArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView musicTitle;
        ShapeableImageView titleImage;
        TextView musicArtist;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            musicTitle = itemView.findViewById(R.id.musicTitle);
            musicArtist = itemView.findViewById(R.id.musicArtist);
            titleImage = itemView.findViewById(R.id.title_image);
        }
    }
}
