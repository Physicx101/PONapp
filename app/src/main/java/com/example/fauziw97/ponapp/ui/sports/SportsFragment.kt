package com.example.fauziw97.ponapp.ui.sports


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.ui.util.GridSpacingItemDecoration
import com.example.fauziw97.ponapp.ui.util.Tools
import com.example.fauziw97.ponapp.ui.util.hide
import com.example.fauziw97.ponapp.ui.util.show
import kotlinx.android.synthetic.main.fragment_sports.*


class SportsFragment : Fragment() {

    private val sportsViewModel by lazy {
        ViewModelProviders.of(activity!!)[SportsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sports, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvSports.layoutManager = GridLayoutManager(context, 3)
        rvSports.setHasFixedSize(true)
        rvSports.addItemDecoration(GridSpacingItemDecoration(3, Tools.dpToPx(context, 8), true))
        sportsViewModel.getSports().observe(this, Observer { it ->
            it.let {
                rvSports.adapter = SportsAdapter(it!!.toMutableList())
            }
        })
        sportsViewModel.isLoading.observe(this, Observer { it ->
            it.let {
                if (it == false) {
                    progressBarSports.hide()
                } else {
                    progressBarSports.show()
                }
            }
        })
    }
}
