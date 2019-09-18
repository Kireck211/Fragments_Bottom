package iteso.mx.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import iteso.mx.fragments.R
import iteso.mx.fragments.fragments.home.FragmentHome
import iteso.mx.fragments.fragments.FragmentProfile
import iteso.mx.fragments.fragments.FragmentSearch

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.activity_main_bnv_navigation)
        navigation.setOnNavigationItemSelectedListener(this)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_main_fl_main_content,
                FragmentHome()
            )
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_home -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content,
                    FragmentHome()
                )
                .commit()
            R.id.action_search -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content, FragmentSearch())
                .commit()
            R.id.action_profile -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content, FragmentProfile())
                .commit()
        }
        return true
    }
}
