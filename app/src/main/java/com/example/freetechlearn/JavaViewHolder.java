package com.example.freetechlearn;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JavaViewHolder extends RecyclerView.ViewHolder {
    public static WebView webView;
    public static Button button;

    public JavaViewHolder(@NonNull View itemView) {
        super(itemView);
        webView=itemView.findViewById(R.id.video1java);
        button=itemView.findViewById(R.id.fullscreen);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        //myself
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccess(true);


    }
}
