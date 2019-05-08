package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity



class SplashScreenActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash_screen)

        //window.requestFeature(Window.FEATURE_NO_TITLE)
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            //finish this activity
            finish()
        },3500)

/*
        val background = object : Thread() {
            override fun run() = try {

                Thread.sleep( 2000)
                val intent = Intent(baseContext, MainActivity::class.java)
                this@SplashScreenActivity.startActivities(arrayOf(intent))
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        background.start() */

    }

}
