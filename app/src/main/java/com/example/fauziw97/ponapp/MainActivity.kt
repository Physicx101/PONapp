package com.example.fauziw97.ponapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.fauziw97.ponapp.ui.medals.MedalsFragment
import com.example.fauziw97.ponapp.ui.schedule.ScheduleFragment
import com.example.fauziw97.ponapp.ui.sports.SportsFragment
import com.example.fauziw97.ponapp.ui.util.loadFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                loadFragment {
                    replace(R.id.container, ScheduleFragment.newInstance(), ScheduleFragment.TAG )
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_medals -> {
                loadFragment {
                    replace(R.id.container, MedalsFragment.newInstance(), MedalsFragment.TAG )
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sports -> {
                loadFragment {
                    replace(R.id.container, SportsFragment.newInstance(), SportsFragment.TAG )
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_atheletes -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFragment {
            replace(R.id.container, ScheduleFragment.newInstance(), ScheduleFragment.TAG )
        }
    }
}
