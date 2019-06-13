package com.khunthong.apps.paakrathjobs2

import android.annotation.SuppressLint
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.khunthong.apps.paakrathjobs2.R.layout


const val url3 = "https://www.paakrathjobs.ga/doctor/"

class DoctorActivity : Fragment() {

    lateinit var mAdView : AdView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layout.bachelor_tab, container, false)
        val refreshLayout = view?.findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        val mWebView = view.findViewById(R.id.webview) as WebView

        mWebView.settings.setAppCacheEnabled(true)
        mWebView.settings.javaScriptEnabled = true
        mWebView.settings.allowContentAccess = true
        mWebView.settings.allowFileAccessFromFileURLs = true
        mWebView.settings.allowFileAccess = true
        mWebView.settings.allowUniversalAccessFromFileURLs = true
        //mWebView.progress.times(200)
        mWebView.loadUrl(url3)
        mWebView.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (Uri.parse(url).host == "https://www.paakrathjobs.ga/doctor/") {
                    return false
                }

                return false
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                mWebView.loadUrl("file:///android_asset/NoInternet.html")
            }

        }

        MobileAds.initialize(context, "ca-app-pub-1596669851189941~4338056569")

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        refreshLayout.setOnRefreshListener {
            mWebView.loadUrl("https://www.paakrathjobs.ga/doctor/")
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

