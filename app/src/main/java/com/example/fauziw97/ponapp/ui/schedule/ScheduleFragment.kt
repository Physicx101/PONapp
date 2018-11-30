package com.example.fauziw97.ponapp.ui.schedule


import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.ui.util.hide
import com.example.fauziw97.ponapp.ui.util.show
import com.example.fauziw97.ponapp.ui.util.toast
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.joda.time.format.DateTimeFormat


class ScheduleFragment : Fragment() {


    private val scheduleViewModel by lazy {
        ViewModelProviders.of(activity!!)[ScheduleViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }


    @SuppressLint("NewApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvSchedule.layoutManager = LinearLayoutManager(context)
        scheduleViewModel.getSchedule().observe(this, Observer { it ->
            it.let {
                rvSchedule.adapter = ScheduleAdapter(it!!.toMutableList())
            }
        })
        scheduleViewModel.isLoading.observe(this, Observer { it ->
            it.let {
                if (it == false) {
                    progressBarSchedule.hide()
                } else {
                    progressBarSchedule.show()
                }
            }
        })
        weekCalendar.setOnDateClickListener {
            val fmt = DateTimeFormat.forPattern("d MMM yyyy")
            val str = it.toString(fmt)
            toast(str, false)
        }
    }

}
