package com.example.safecrowd.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safecrowd.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationFragment} factory method to
 * create an instance of this fragment.
 */
public class LocationFragment extends Fragment {

    private static final String TAG = "LocationFragment";

    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Marker mapMarker = map.addMarker(new MarkerOptions()
//                .position(listingPosition)
//                .title("Some title here")
//                .snippet("Some description here")
//                .icon(defaultMarker));
    }
}