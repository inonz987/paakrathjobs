package com.khunthong.apps.paakrathjobs2

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(){


    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        setSupportActionBar(toolbar)

        // Now get the support action bar
        val actionBar = supportActionBar

        // Set toolbar title/app title
        actionBar!!.title = " งานภาครัฐ"

        /*
        Set action bar/toolbar sub title
        actionBar.subtitle = "App subtitle"
        Set action bar elevation
        actionBar.elevation = 2.0F
        Display the app icon in action bar/toolbar
        */
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setLogo(R.drawable.ic_titlebar_logo)
        //actionBar.setLogo(R.mipmap.ic_launcher)
        actionBar.setDisplayUseLogoEnabled(true)

        /*swipe_refresh_layout.setOnRefreshListener {
            Handler().postDelayed({



                swipe_refresh_layout.isRefreshing = false
            }, 3000)
        }
        swipe_refresh_layout.setColorSchemeColors(Color.parseColor("#008744"), Color.parseColor("#0057e7"),Color.parseColor("#d62d20"))
*/
   }


   override fun onCreateOptionsMenu(menu: Menu): Boolean {
       // Inflate the menu; this adds items to the action bar if it is present.
       menuInflater.inflate(R.menu.menu_main, menu)
       return true
   }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
       // Handle action bar item clicks here. The action bar will
       // automatically handle clicks on the Home/Up button, so long
       // as you specify a parent activity in AndroidManifest.xml.
       val id = item.itemId

       if (id == R.id.action_settings) {
          val intent = Intent(this@MainActivity, AboutActivity::class.java)
           startActivity(intent)
           finish()
       }

       return super.onOptionsItemSelected(item)
   }

   private var doubleBackToExitPressedOnce = false
   override fun onBackPressed() {
       if (doubleBackToExitPressedOnce)
       {
           super.onBackPressed()
           return
       }
       this.doubleBackToExitPressedOnce = true
       //Toast.makeText(this, "กดย้อนกลับอีกครั้งเพื่อออกจากแอป", Toast.LENGTH_SHORT).show()
       //Toasty.normal(this, "กดย้อนกลับอีกครั้งเพื่อออกจากแอป",R.drawable.ic_app_logo).show()
       Toasty.warning(this,"กดย้อนกลับอีกครั้งเพื่อออกจากแอป",Toast.LENGTH_SHORT, true).show()

   Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 4000)
   }

   /**
    * A [FragmentPagerAdapter] that returns a fragment corresponding to
    * one of the sections/tabs/pages.

   inner class SectionsPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {
    */

   inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
       override fun getItem(position: Int): Fragment {

           /** Fun to check network status */
           fun isNetworkStatusActive(): Boolean {

               val cm = getSystemService(Context.CONNECTIVITY_SERVICE)

               if (cm is ConnectivityManager) {
                   val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
                   val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
                   //val isWiFi: Boolean = activeNetwork?.type == ConnectivityManager.TYPE_WIFI

                   if (!isConnected) {

                       return false
                   }
               }

               return true
           }

           // To check network status if no connection intent to sorry activity :)
           if (!isNetworkStatusActive())

           {

               val intent = Intent(this@MainActivity, NoconnectionActivity::class.java)
               startActivity(intent)
               finish()
           }

               when(position){

                   0 -> {
                       return BachelorActivity()
                   }
                   1 -> {
                       return MasterActivity()
                   }
                   2 -> {
                       return DoctorActivity()
                   }
                   3 -> {
                       return OtherActivity()
                   }

                   else -> {return BachelorActivity()}

               }


       }



       override fun getCount(): Int {
           // Show 4 total pages.
           return 4
       }

       override fun getPageTitle(position: Int): CharSequence?
       {
             when(position)
             {
                   0 -> return "Bachelor"
                   1 -> return "Master"
                   2 -> return "Doctor"
                   3 -> return "Other"

             }
           return null

       }

   }


}

