package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class NoconnectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nointernetconn)

        val imageview = findViewById<ImageView>(R.id.imageView11)
        imageview.setOnClickListener {
            val intent = Intent(this@NoconnectionActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}
