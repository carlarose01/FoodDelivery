package com.example.safecrowd.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.safecrowd.R;
import com.example.safecrowd.fragments.AlertFragment;
import com.example.safecrowd.fragments.LocationFragment;
import com.example.safecrowd.fragments.ProfileFragment;
import com.example.safecrowd.fragments.PostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    public static FragmentManager fragmentManager;
    private ChipNavigationBar bottomNavigationView;

    @Override
    @SuppressWarnings("DEPRECATION")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment;
                switch (i) {
                    case R.id.home:
                        fragment = new PostFragment();
                        break;
                    case R.id.alert:
                        fragment = new AlertFragment();
                        break;
                    case R.id.location:
                        fragment = new LocationFragment();
                        break;
                    case R.id.profile:
                    default:
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            }
        });
        // Set default selection
        bottomNavigationView.setItemSelected(R.id.home, true);
    }

    public static void goUserProfile(ParseUser user) {
        Fragment fragment = new ProfileFragment(user);
        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
    }

}