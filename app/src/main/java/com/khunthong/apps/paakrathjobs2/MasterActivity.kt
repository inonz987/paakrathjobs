package com.khunthong.apps.paakrathjobs2

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MasterActivity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bachelor_tab, container, false)
        val refreshLayout = view.findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        val mWebView = view.findViewById(R.id.webview) as WebView
        mWebView.settings.setAppCacheEnabled(true)
        mWebView.settings.javaScriptEnabled
        mWebView.loadUrl("https://www.paakrathjobs.ga/post2/")
        mWebView.webViewClient = WebViewClient()

        refreshLayout.setOnRefreshListener {
            mWebView.loadUrl("https://www.google.co.th")
            Handler().postDelayed({
                refreshLayout.isRefreshing = false
            }, 2500)

        }
        refreshLayout.setColorSchemeColors(
            Color.parseColor("#008744"), Color.parseColor("#0057e7"),
            Color.parseColor("#d62d20")
        )

        return view
    }
}
