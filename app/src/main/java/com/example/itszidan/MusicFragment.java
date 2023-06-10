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

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Music> musicArrayList;
    private RecyclerView recylerView;
    private String[] musicTitle;
    private String[] musicArtist;
    private int[] ImageResourceID;

    public MusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
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
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "jpGckPKSqzM";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recylerView = view.findViewById(R.id.recycler);
        recylerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recylerView.setHasFixedSize(true);

        MusicAdapter musicAdapter = new MusicAdapter(getContext(), musicArrayList);
        recylerView.setAdapter(musicAdapter);

        musicAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        musicArrayList = new ArrayList<>();

        musicTitle = new String[]{
                getString(R.string.music_title_1),
                getString(R.string.music_title_2),
                getString(R.string.music_title_3),
                getString(R.string.music_title_4),
                getString(R.string.music_title_5)
        };

        musicArtist= new String[]{
                getString(R.string.music_artist_1),
                getString(R.string.music_artist_2),
                getString(R.string.music_artist_3),
                getString(R.string.music_artist_4),
                getString(R.string.music_artist_5)
        };

        ImageResourceID = new int[]{
                R.drawable.music_cover_1,
                R.drawable.music_cover_2,
                R.drawable.music_cover_3,
                R.drawable.music_cover_4,
                R.drawable.music_cover_5
        };


        for(int i = 0; i < musicTitle.length; i++) {
            Music music = new Music(musicTitle[i], musicArtist[i], ImageResourceID[i]);
            musicArrayList.add(music);
        };
    }
}