package com.example.itszidan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recylerView;
    private ArrayList<Gallery> galleryArrayList;
    private String[] titlePhoto;
    private int[] imageResourceID;

    private GalleryAdapter adapter;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recylerView = view.findViewById(R.id.recycler);
        recylerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recylerView.setHasFixedSize(true);

        GalleryAdapter galleryAdapter = new GalleryAdapter(getContext(), galleryArrayList);
        recylerView.setAdapter(galleryAdapter);
        galleryAdapter.notifyDataSetChanged();
    }

    public void dataInitialize() {
        galleryArrayList = new ArrayList<>();

        titlePhoto = new String[]{
            getString(R.string.galeri_caption_1),
                getString(R.string.galeri_caption_2),
                getString(R.string.galeri_caption_3),
                getString(R.string.galeri_caption_4)
        };

        imageResourceID = new int[]{
                R.drawable.galeri_1,
                R.drawable.galeri_2,
                R.drawable.galeri_3,
                R.drawable.galeri_4
        };

        for (int i = 0; i < titlePhoto.length; i++) {
            Gallery gallery = new Gallery(titlePhoto[i], imageResourceID[i]);
            galleryArrayList.add(gallery);
        }
    }
}