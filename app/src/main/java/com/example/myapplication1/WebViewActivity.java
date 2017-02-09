package com.example.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    static Button openURLButton;
    static EditText urlText;
    static WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        addOpenURLButtonClickListener();
    }

    public void addOpenURLButtonClickListener(){
        openURLButton = (Button)findViewById(R.id.button_OpenURL);
        urlText = (EditText)findViewById(R.id.editText_URL);
        browser = (WebView)findViewById(R.id.WebView_webView);

        openURLButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = urlText.getText().toString();
                        browser.getSettings().setLoadsImagesAutomatically(true);
                        browser.getSettings().setJavaScriptEnabled(true);
                        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        browser.loadUrl(url);
                    }
                }
        );
    }
}
