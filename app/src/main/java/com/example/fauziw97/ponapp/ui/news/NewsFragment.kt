package com.example.fauziw97.ponapp.ui.news


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fauziw97.ponapp.R
import com.example.fauziw97.ponapp.ui.util.gone
import com.example.fauziw97.ponapp.ui.util.hide
import com.example.fauziw97.ponapp.ui.util.show
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*
import kotlinx.android.synthetic.main.toolbar.*

class NewsFragment : Fragment() {

    private val newsViewModel by lazy {
        ViewModelProviders.of(activity!!)[NewsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        view.image_header.clipToOutline = true
        view.layout_header.gone()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemDecor = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDecor.setDrawable(context!!.getDrawable(R.drawable.divider))
        rvNews.layoutManager = LinearLayoutManager(context)
        rvNews.addItemDecoration(itemDecor)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        newsViewModel.isLoading.observe(this, Observer { it ->
            it.let {
                if (it == false) {
                    progressBarNews.hide()
                    layout_header.show()
                } else {
                    progressBarNews.show()
                    layout_header.gone()
                }
            }
        })
        newsViewModel.getNews().observe(this, Observer { it ->
            it.let {
                rvNews.adapter = NewsAdapter(it!!.toMutableList())
            }
        })
    }


}
