package com.example.fauziw97.ponapp.ui.medals


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
import kotlinx.android.synthetic.main.fragment_medals.*


class MedalsFragment : Fragment() {

    private val medalsViewModel by lazy {
        ViewModelProviders.of(activity!!)[MedalsViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_medals, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvMedals.layoutManager = LinearLayoutManager(context)
        medalsViewModel.getMedals().observe(this, Observer { it ->
            it.let {
                rvMedals.adapter = MedalsAdapter(it!!.toMutableList())
            }
        })
        medalsViewModel.isLoading.observe(this, Observer { it ->
            it.let {
                if (it == false) {
                    progressBarMedals.hide()
                } else {
                    progressBarMedals.show()
                }
            }
        })
    }

}
