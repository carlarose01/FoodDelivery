package com.example.safecrowd.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.safecrowd.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlertFragment} factory method to
 * create an instance of this fragment.
 */
public class AlertFragment extends Fragment {

    private WebView myWebView;

    public AlertFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        myWebView = (WebView) view.findViewById(R.id.webview);
//        // Configure related browser settings
//        myWebView.getSettings().setLoadsImagesAutomatically(true);
//        myWebView.getSettings().setJavaScriptEnabled(true);
//        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        // Configure the client to use when opening URLs
//        myWebView.setWebViewClient(new WebViewClient());
//        // Load the initial URL
//        myWebView.loadUrl("http://www.example.com");
//    }
}