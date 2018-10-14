package com.example.cas.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PortalViewActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal_view);



        mWebView = findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());

        mWebView.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getStringExtra("url");
        mWebView.loadUrl(url);

//        WebSettings webSettings = mWebView.getSettings();
//
//        String url = getIntent().getStringExtra("url");
//        mWebView.loadUrl(url);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return;
        }
        super.onBackPressed();
    }
}
