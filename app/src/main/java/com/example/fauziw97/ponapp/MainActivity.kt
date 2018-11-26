package com.example.fauziw97.ponapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.fauziw97.ponapp.ui.athletes.AthletesFragment
import com.example.fauziw97.ponapp.ui.medals.MedalsFragment
import com.example.fauziw97.ponapp.ui.news.NewsFragment
import com.example.fauziw97.ponapp.ui.schedule.ScheduleFragment
import com.example.fauziw97.ponapp.ui.sports.SportsFragment
import com.example.fauziw97.ponapp.ui.util.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_news -> {
                replaceFragment(NewsFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_schedule -> {
                replaceFragment(ScheduleFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_medals -> {
                replaceFragment(MedalsFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sports -> {
                replaceFragment(SportsFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_atheletes -> {
                replaceFragment(AthletesFragment(), R.id.container)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(NewsFragment(), R.id.container)
    }
}
