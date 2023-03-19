package com.example.freetechlearn;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HtmlViewHolder extends RecyclerView.ViewHolder {
    public static WebView webView;
    public static Button button;

    public HtmlViewHolder(@NonNull View itemView) {
        super(itemView);
        webView=itemView.findViewById(R.id.video1html);
        button=itemView.findViewById(R.id.fullscreenhtml);
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
