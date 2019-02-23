package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
