package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class AboutActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-1596669851189941~4338056569")
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-1596669851189941/2904242313"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        val imageview = findViewById<ImageView>(R.id.imageView11)
        imageview.setOnClickListener {

            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                val intent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            mInterstitialAd.adListener = object : AdListener() {
                override fun onAdClosed() {
                    val intent = Intent(this@AboutActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            //val intent = Intent(this@AboutActivity, MainActivity::class.java)
            //startActivity(intent)
            //finish()
        }


        val callback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                val intent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        this@AboutActivity.onBackPressedDispatcher.addCallback(this, callback)

    }


}
