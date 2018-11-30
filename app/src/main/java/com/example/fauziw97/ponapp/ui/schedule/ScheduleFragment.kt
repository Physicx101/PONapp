package com.example.fauziw97.ponapp.ui.schedule


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.ui.util.toast
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.joda.time.format.DateTimeFormat


class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }


    @SuppressLint("NewApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weekCalendar.setOnDateClickListener {
            val fmt = DateTimeFormat.forPattern("d MMM yyyy")
            val str = it.toString(fmt)
            toast(str, true)
        }
    }



}
