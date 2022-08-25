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

public class Facebook extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        webView = (WebView) findViewById(R.id.fb_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.facebook.com");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_facebook);
        bottomNavigationView.setSelectedItemId(R.id.fb);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.yt:
                        startActivity(new Intent(getApplication(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.fb:

                        return true;
                    case R.id.twitter:
                        startActivity(new Intent(getApplication(), Twitter.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
    }
}
