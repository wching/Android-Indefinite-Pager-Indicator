package com.rbrooks.indefinitepagerindicatorsample.viewPagerSample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener

class ViewPagerSampleFragment : Fragment(), OnPagerNumberChangeListener {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerIndicator: IndefinitePagerIndicator

    private var pagerAdapter: ViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager_sample, container, false)

        bindViews(view)
        setupViews()

        return view
    }

    private fun bindViews(view: View) {
        viewPager = view.findViewById(R.id.viewpager)
        pagerIndicator = view.findViewById(R.id.viewpager_pager_indicator)
    }

    private fun setupViews() {
        pagerAdapter = ViewPagerAdapter(context)
        viewPager.adapter = pagerAdapter
        pagerIndicator.attachToViewPager(viewPager)
    }

    override fun onPagerNumberChanged() {
        pagerAdapter?.notifyDataSetChanged()
    }
}