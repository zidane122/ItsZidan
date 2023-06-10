package com.example.itszidan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {
    Context context;
    ArrayList<Friend> friendArrayList;

    public FriendAdapter(Context context, ArrayList<Friend> friendArrayList) {
        this.context = context;
        this.friendArrayList = friendArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.friend_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Friend friend = friendArrayList.get(position);

        holder.friendName.setText(friend.friendName);
    }

    @Override
    public int getItemCount() {
        return friendArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView friendName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            friendName = itemView.findViewById(R.id.friendName);
        }
    }
}
