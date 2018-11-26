package com.example.fauziw97.ponapp.ui.athletes


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
import kotlinx.android.synthetic.main.fragment_athletes.*

class AthletesFragment : Fragment() {

    private val athletesViewModel by lazy {
        ViewModelProviders.of(activity!!)[AthletesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_athletes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvAthletes.layoutManager = LinearLayoutManager(context)
        athletesViewModel.getAthletes().observe(this, Observer { it ->
            it.let {
                rvAthletes.adapter = AthletesAdapter(it!!.toMutableList())
            }
        })
        athletesViewModel.isLoading.observe(this, Observer { it ->
            it.let {
                if (it == false) {
                    progressBarAthletes.hide()
                } else {
                    progressBarAthletes.show()
                }
            }
        })
    }
}
