package com.example.itszidan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class DailyActivityAdapter extends RecyclerView.Adapter<DailyActivityAdapter.MyViewHolder> {

    Context context;
    ArrayList<DailyActivity> dailyActivityArrayList;

    public DailyActivityAdapter(Context context, ArrayList<DailyActivity> dailyActivityArrayList) {
        this.context = context;
        this.dailyActivityArrayList = dailyActivityArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.daily_activity_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DailyActivity dailyActivity = dailyActivityArrayList.get(position);

        holder.activityName.setText(dailyActivity.activityHeading);
        holder.activityTime.setText(dailyActivity.activityTime);
    }

    @Override
    public int getItemCount() {
        return dailyActivityArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView activityName;
        TextView activityTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            activityName = itemView.findViewById(R.id.activityName);
            activityTime = itemView.findViewById(R.id.activityTime);
        }
    }
}
