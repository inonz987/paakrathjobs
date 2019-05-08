package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebViewClientCompat
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val mywebview: WebView? = this.findViewById(R.id.webview_detail)
        webview_detail.setBackgroundColor(Color.LTGRAY)
        mywebview?.settings?.javaScriptEnabled
        mywebview?.webViewClient = MyWebViewClient()


        val imageview = findViewById<ImageView>(R.id.imageView11)
        imageview.setOnClickListener {
            val intent = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
            //val view = inflate(R.layout.activity_detail, container, false)
            //val refreshLayout = view.findViewById (R.id.swipe_refresh_layout) as SwipeRefreshLayout
            //val mWebView = view.findViewById(R.id.webview) as WebView
            //mWebView.settings.setAppCacheEnabled(true)
            //mWebView.settings.javaScriptEnabled
            //mWebView.loadUrl()
            //mWebView.webViewClient = WebViewClient()

        }

        /*  override fun onCreate(savedInstanceState: Bundle?) {
              super.onCreate(savedInstanceState)
              setContentView(R.layout.activity_detail)

              val imageview = findViewById<ImageView>(R.id.imageView11)
              imageview.setOnClickListener {
                  val intent = Intent(this@DetailActivity, MainActivity::class.java)
                  startActivity(intent)
                  finish()
              }

             class MyWebViewClient : WebViewClient() {
                  private var url = "https://www.paakrathjobs.ga/post2/"
                  override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                      if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {
                          // This is my web site, so do not override; let my WebView load the page
                          return false
                      }
                      //Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                      Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                          //val intent = Intent(this@MyWebViewClient, AboutActivity::class.java)
                          //ContextCompat.startActivity(intent)
                          //finish()
                      }

                      return true
                  }
              }

          }*/

    }
}

class MyWebViewClient : WebViewClientCompat() {
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        return super.shouldOverrideUrlLoading(view, request)

    }


    /* override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
         if (Uri.parse(url).host == "https://www.paakrathjobs.ga/post2/") {
             // This is my web site, so do not override; let my WebView load the page
             return false
         }
         // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
         Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
             //ContextCompat.startActivity(this)
             //fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Boolean {

             //val view2 = inflater.inflate(R.layout.bachelor_tab, container, false)
             mWebView.setOnClickListener {
                 //val intent = AboutActivity.Intent(this@BachelorActivity, AboutActivity::class.java)
                 //startActivity(intent)
                 //val myWebView: WebView = view2.findViewById(R.id.webview)
                 //myWebView.webViewClient = MyWebViewClient()
             }

             return true
         }
     }*/

}