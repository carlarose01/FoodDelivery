package com.example.safecrowd.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.safecrowd.activity.EditProfileActivity;
import com.example.safecrowd.activity.LoginActivity;
import com.example.safecrowd.activity.OpeningActivity;
import com.example.safecrowd.R;
import com.example.safecrowd.models.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.parse.ParseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Profile Fragment";

    private ProgressBar pb;

    public long userId;
    public String screenName;
    private TextView tvUserNameP;
    private TextView tvSinceP;
    private TextView tvUserDescription;
    private FloatingActionButton ivProfileImageP;
    Button btnEdit;
    Button btnLogout;

    private ParseUser user;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileFragment(ParseUser user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // This example uses decor view, but you can use any visible view.
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
        //pb = (ProgressBar) view.findViewById(R.id.pbLoading);

        userId = getActivity().getIntent().getLongExtra("user_uid", -1);
        screenName = getActivity().getIntent().getStringExtra("screenName");
//        if (userId == -1){
//            onError(0, null);
//        } else if (screenName == null) {
//            onError(0, "Screen name was null");
//        }

        tvUserNameP = (TextView) view.findViewById(R.id.tvUserNameP);
        tvSinceP = (TextView) view.findViewById(R.id.tvSinceP);
        tvUserDescription = (TextView) view.findViewById(R.id.tvUserDescription);
        btnEdit = view.findViewById(R.id.btnEdit);
        btnLogout = view.findViewById(R.id.btnLogout);

        ivProfileImageP = (FloatingActionButton) view.findViewById(R.id.ivProfileImageP);

        user = ParseUser.getCurrentUser();

        if (!user.getUsername().equals(ParseUser.getCurrentUser().getUsername())) {
            btnEdit.setVisibility(View.GONE);
            btnLogout.setVisibility(View.GONE);
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goEditProfile();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                goLogin();
                //goOpening();
            }
        });

        populateUserHeadline(user);
    }

    private void goLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void goOpening() {
        Intent intent = new Intent(getContext(), OpeningActivity.class);
        startActivity(intent);
    }

    public void goEditProfile() {
        Intent intent = new Intent(getContext(), EditProfileActivity.class);
        getContext().startActivity(intent);
    }

    public void populateUserHeadline(final ParseUser user) {
        // populate the screen with info gathered
        tvUserNameP.setText(user.getUsername());
        tvSinceP.setText("On SafeCrowd since " + user.getCreatedAt());
        if (user.getString(Post.KEY_BIO) == null) {
            tvUserDescription.setVisibility(View.GONE);
        } else {
            tvUserDescription.setText(user.getString(Post.KEY_BIO));
        }
//        tvUserDescription.setText(user.getEmail()); // dont have description
//        if (user.getEmail().length() <= 1) { // if description is short dont show
//            tvUserDescription.setVisibility(View.GONE);
//        }
        // add the images
//        Glide.with(getActivity().getBaseContext()).load(user.getProfileImage())
//                .placeholder(R.drawable.ic_profile)
//                .error(R.drawable.ic_profile)
//                .into(ivProfileImageP);
        }

//    public void onError(int code, String message) {
//        String onErrorString = "onError error occurred";
//        switch (code) {
//            case 0: {
//                // error while parsing the userId
//                Toast.makeText(getActivity().getBaseContext(), String.format("Error occurred while parsing the userId. %s", message), Toast.LENGTH_LONG).show();
//                break;
//            }
//            case 1: {
//                // error while parsing the json from twitter server response
//                Toast.makeText(getActivity().getBaseContext(), String.format("Error occurred while while parsing the json from the twitter server response. %s", message), Toast.LENGTH_LONG).show();
//                break;
//            }
//            case 2: {
//                // error while sending a request to twitter server
//                Toast.makeText(getActivity().getBaseContext(), String.format("Error occurred while while sending a request to the twitter server. %s", message), Toast.LENGTH_LONG).show();
//                break;
//            }
//            default: {
//                // unidentified error
//                Toast.makeText(getActivity().getBaseContext(), String.format("Unidentified error occured."), Toast.LENGTH_LONG).show();
//                break;
//            }
//        }
//        Log.e(TAG, String.format("%s at %s: %s", onErrorString, code, message));
//        getActivity().finish(); // finish because bad error
//    }
}