package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.view.View
import android.widget.ImageView
import java.lang.Exception



class SplashScreenActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread() {
            override fun run() = try {

                Thread.sleep( 2000)
                val intent = Intent(baseContext, MainActivity::class.java)
                this@SplashScreenActivity.startActivities(arrayOf(intent))
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        background.start()

    }

}
