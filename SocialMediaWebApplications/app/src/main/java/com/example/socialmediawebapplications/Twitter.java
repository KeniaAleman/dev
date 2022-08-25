package com.example.socialmediawebapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Twitter extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        webView = (WebView) findViewById(R.id.twitter_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.twitter.com");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_twitter);
        bottomNavigationView.setSelectedItemId(R.id.yt);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.yt:
                        startActivity(new Intent(getApplication(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.fb:
                        startActivity(new Intent(getApplication(), Facebook.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.twitter:
                        return true;
                }
                return false;
            }
        });
    }
}
