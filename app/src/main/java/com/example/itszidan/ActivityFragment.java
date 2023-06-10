package com.example.itszidan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ActivityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<DailyActivity> activityArrayList;
    private String[] activityName;
    private int[] imageResourceID;
    private RecyclerView recylerView;
    private String[] activityTime;
    private String[] friendName;
    private ArrayList<Friend> friendArrayList;

    public ActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityFragment newInstance(String param1, String param2) {
        ActivityFragment fragment = new ActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        // Activity Recycler
        RecyclerView recyclerView1 = view.findViewById(R.id.recycler);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView1.setHasFixedSize(true);

        DailyActivityAdapter dailyActivityAdapter = new DailyActivityAdapter(getContext(), activityArrayList);
        recyclerView1.setAdapter(dailyActivityAdapter);

        dailyActivityAdapter.notifyDataSetChanged();

        // Friend Recycler
        RecyclerView recyclerView2 = view.findViewById(R.id.recylerFriend);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);

        FriendAdapter friendAdapter = new FriendAdapter(getContext(), friendArrayList);
        recyclerView2.setAdapter(friendAdapter);

        friendAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        activityArrayList = new ArrayList<>();
        friendArrayList = new ArrayList<>();

        activityName = new String[]{
            getString(R.string.activity_title_1),
            getString(R.string.activity_title_2),
            getString(R.string.activity_title_3),
            getString(R.string.activity_title_4),
            getString(R.string.activity_title_5),
            getString(R.string.activity_title_6),
            getString(R.string.activity_title_7),
                getString(R.string.activity_title_8),
                getString(R.string.activity_title_9),
                getString(R.string.activity_title_10),
                getString(R.string.activity_title_11),
                getString(R.string.activity_title_12),

        };

        activityTime= new String[]{
                getString(R.string.activity_time_1),
                getString(R.string.activity_time_2),
                getString(R.string.activity_time_3),
                getString(R.string.activity_time_4),
                getString(R.string.activity_time_5),
                getString(R.string.activity_time_6),
                getString(R.string.activity_time_7),
                getString(R.string.activity_time_8),
                getString(R.string.activity_time_9),
                getString(R.string.activity_time_10),
                getString(R.string.activity_time_11),
                getString(R.string.activity_time_12),
        };

        friendName = new String[]{
                getString(R.string.friend_name_1),
                getString(R.string.friend_name_2),
                getString(R.string.friend_name_3),
                getString(R.string.friend_name_4),
                getString(R.string.friend_name_5),
                getString(R.string.friend_name_6),
                getString(R.string.friend_name_7),
                getString(R.string.friend_name_8),
                getString(R.string.friend_name_9),
                getString(R.string.friend_name_10),

        };

        for(int i = 0; i < activityName.length; i++) {
            DailyActivity dailyActivity = new DailyActivity(activityName[i], activityTime[i]);
            activityArrayList.add(dailyActivity);
        };

        for(int i = 0; i < friendName.length; i++) {
            Friend friend = new Friend(friendName[i]);
            friendArrayList.add(friend);
        }
    }
}