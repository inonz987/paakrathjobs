package com.khunthong.apps.paakrathjobs2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.dmoral.toasty.Toasty

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

        val retry = findViewById<ImageView>(R.id.retrybutt)
        retry.setOnClickListener {
            val intent = Intent(this@NoconnectionActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        //Toast.makeText(this, "กดย้อนกลับอีกครั้งเพื่อออกจากแอป", Toast.LENGTH_SHORT).show()
        //Toasty.normal(this, "กดย้อนกลับอีกครั้งเพื่อออกจากแอป",R.drawable.ic_app_logo).show()
        Toasty.warning(this, "กดย้อนกลับอีกครั้งเพื่อออกจากแอป", Toast.LENGTH_SHORT, true).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 4000)
        finish()
    }
}
