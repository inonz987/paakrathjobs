package com.khunthong.apps.paakrathjobs2

import android.annotation.SuppressLint
import android.graphics.Bitmap
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
import com.airbnb.lottie.LottieAnimationView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.khunthong.apps.paakrathjobs2.R.layout
import kotlinx.android.synthetic.main.bachelor_tab.*


const val url = "https://www.paakrathjobs.ga/barchelor/"

class BachelorActivity : Fragment() {

    lateinit var mAdView: AdView
    lateinit var animationView: LottieAnimationView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(layout.bachelor_tab, container, false)
        val refreshLayout = view?.findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        val mWebView = view.findViewById(R.id.webview) as WebView
        //animation_view2.setAnimation("glowloading.json")
        //animation_view2.playAnimation()
        //animation_view2.loop(false)
/*if(savedInstanceState == null) {
        animationView = view.findViewById(R.id.animation_view2)
        animationView.apply {
            speed = 0.7f
            setAnimation("glowloading.json")
            playAnimation()
            Handler().postDelayed({
                animationView.cancelAnimation()
                animation_view2.visibility = View.INVISIBLE
            }, 3500)
        } }*/
        //animationView.cancelAnimation()
        mWebView.settings.setAppCacheEnabled(true)
        mWebView.settings.javaScriptEnabled = true
        mWebView.settings.allowContentAccess = true
        mWebView.settings.allowFileAccessFromFileURLs = true
        mWebView.settings.allowFileAccess = true
        mWebView.settings.allowUniversalAccessFromFileURLs = true
        //mWebView.progress.times(200)
        mWebView.loadUrl(url)
        mWebView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (Uri.parse(url).host == "https://www.paakrathjobs.ga/barchelor/") {
                    return false
                }

                // val intent= Intent(Intent.ACTION_VIEW, Uri.parse(url))
                //startActivity(intent)
                //return true
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                    //view?.visibility = View.INVISIBLE
                if (view != null) {
                    animationView = view.findViewById(R.id.animation_view2)
                }
                animationView.apply {
                    speed = 0.7f
                    animation_view2.visibility = View.VISIBLE
                    animation_view2.loop(true)
                    setAnimation("glowloading.json")
                    playAnimation()

            } }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                animation_view2.visibility = View.INVISIBLE
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


        //mWebView.setDownloadListener(true)


        //mWebView.webViewClient = WebViewClient()

/*
        mWebView.setOnClickListener {

            val intent = Intent(mWebView.context, DetailActivity::class.java)
            intent.putExtra("value", String())
            mWebView.context.startActivity(intent)
        }
*/
        //animation_view2.setAnimation("glowloading.json")

        refreshLayout.setOnRefreshListener {
            mWebView.loadUrl("https://www.paakrathjobs.ga/barchelor/")
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


/*
private class My2WebViewClient : WebViewClientCompat() {

    fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url.toString()
        if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {
            // This is my web site, so do not override; let my WebView load the page
            return false
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        //Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
        //startActivity(this)

        Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            return true

        }

    }
}  */


/*

private class My2WebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        val layoutInflater= LayoutInflater.from(view?.context)
        val myWebView = view?.findViewById(R.id.webview) as WebView

        if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {
            return false
        }

        val intent  = Intent (Intent.ACTION_VIEW, Uri.parse(url),DetailActivity::class.java)
        startActivity(intent)
        return true
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request?.url.toString()

        if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {
            return false
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
        return true

    }
}



*/

/*
class My2WebViewClient : WebViewClientCompat() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String?, request: WebResourceRequest) : Boolean {


        if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {

            return true
        }


        if (request.hasGesture()) Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            Intent (view, DetailActivity::class.java)
            startActivity(this)
        }
    }

}

        */


/* 21.04.19
/
private class My3WebViewClient : WebViewClientCompat() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {
            // This is my web site, so do not override; let my WebView load the page
            return false
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        //Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            //startActivity(this)
                DetailActivity()
        //}
        return true
    }
}
*/

/*  To download with dialog box but need to be correct the code
*
*         mWebView.setDownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
            //getting file name from url.
            val filename = URLUtil.guessFileName(url, contentDisposition, mimetype)
            //Alertdialog
            val builder = AlertDialog.Builder(mWebView.context)
            //title for AlertDialog
            builder.setTitle("DOWNLOAD")
            //message of AlertDialog
            builder.setMessage("ต้องการดาวน์โหลดไฟล์นี้? $filename")
            //When YES button clicks
            builder.setPositiveButton("ใช่") { dialog, which ->
                //DownloadManager.Request created with url.
                val request = DownloadManager.Request(Uri.parse(url))
                //cookie
                val cookie = CookieManager.getInstance().getCookie(url)
                //Add cookie and User-Agent to request
                request.addRequestHeader("Cookie",cookie)
                request.addRequestHeader("User-Agent",userAgent)
                //file scanned by MediaScannar
                request.allowScanningByMediaScanner()
                //Download is visible and its progress, after completion too.
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                //DownloadManager created
                //val downloadmanager = getSystemService (Context.DOWNLOAD_SERVICE) as DownloadManager
                //Saving file in Download folder
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,filename)
                //download enqued
                //downloadmanager.enqueue(request)
            }
            builder.setNegativeButton("ยกเลิก")
            {dialog, which ->
                //cancel the dialog if Cancel clicks
                dialog.cancel()
            }

            val dialog:AlertDialog = builder.create()
            //alertdialog shows
            dialog.show()



        }
            //getting file name from url.
*
*
* */