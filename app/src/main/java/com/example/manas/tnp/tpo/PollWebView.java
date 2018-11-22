package com.example.manas.tnp.tpo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PollWebView extends AppCompatActivity {

    private String url_load;
    private String intent_of_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll_web_view);

        Intent mainActivity = getIntent();
        url_load = mainActivity.getStringExtra("passable_url");
        WebView webView = findViewById(R.id.simpleWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url_load);
    }
}

