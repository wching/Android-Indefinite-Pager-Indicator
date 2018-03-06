package com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener

class RecyclerViewSampleFragment : Fragment(), OnPagerNumberChangeListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pagerIndicator: IndefinitePagerIndicator
    private lateinit var pagerIndicatorHorizontal: IndefinitePagerIndicator

    private var recyclerViewAdapter: PhotoItemRecyclerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recyclerview_sample, container, false)

        bindViews(view)
        setupViews()

        return view
    }

    private fun bindViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview)
        pagerIndicator = view.findViewById(R.id.recyclerview_pager_indicator)
        pagerIndicatorHorizontal = view.findViewById(R.id.recyclerview_pager_indicator_horizontal)
    }

    private fun setupViews() {
        recyclerViewAdapter = PhotoItemRecyclerAdapter(context)
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        pagerIndicator.attachToRecyclerView(recyclerView)
        pagerIndicatorHorizontal.attachToRecyclerView(recyclerView)
    }

    override fun onPagerNumberChanged() {
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}