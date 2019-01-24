package com.khunthong.apps.paakrathjobs2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class MasterActivity : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.master_tab, container, false)
        val mWebView = view.findViewById(R.id.webview) as WebView
        mWebView.loadUrl("https://www.paakrathjobs.ga/post/")
        // Enable Javascript
        //val webSettings = mWebView.getSettings()
        //webSettings.setJavaScriptEnabled(true)
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.webViewClient = WebViewClient()
        return view
    }
}