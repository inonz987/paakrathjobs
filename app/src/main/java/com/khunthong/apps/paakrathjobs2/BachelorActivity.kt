package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class BachelorActivity : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bachelor_tab, container, false)
        val mWebView = view.findViewById(R.id.webview) as WebView
        mWebView.loadUrl("https://www.paakrathjobs.ga/post/")
        mWebView.webViewClient = WebViewClient()
        return view
    }
}