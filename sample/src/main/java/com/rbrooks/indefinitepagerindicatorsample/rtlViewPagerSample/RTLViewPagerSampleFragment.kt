package com.rbrooks.indefinitepagerindicatorsample.viewPagerSample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener

class RTLViewPagerSampleFragment : Fragment(), OnPagerNumberChangeListener, View.OnClickListener {
    private lateinit var viewPager: ViewPager

    private lateinit var pagerIndicator: IndefinitePagerIndicator
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private var pagerAdapter: ViewPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rtl_view_pager_sample, container, false)

        bindViews(view)
        setupViews()

        return view
    }

    private fun bindViews(view: View) {
        viewPager = view.findViewById(R.id.viewpager)
        pagerIndicator = view.findViewById(R.id.viewpager_pager_indicator)
        previousButton = view.findViewById(R.id.viewpager_previous_button)
        nextButton = view.findViewById(R.id.viewpager_next_button)
    }

    private fun setupViews() {
        pagerAdapter = ViewPagerAdapter(context)
        viewPager.adapter = pagerAdapter
        pagerIndicator.attachToViewPager(viewPager)

        previousButton.setOnClickListener(this)
        nextButton.setOnClickListener(this)
    }

    override fun onPagerNumberChanged() {
        pagerAdapter?.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.viewpager_previous_button -> {
                if (viewPager.currentItem == 0) {
                    viewPager.currentItem = viewPager.adapter.count - 1
                } else {
                    viewPager.currentItem = viewPager.currentItem - 1
                }
            }
            R.id.viewpager_next_button -> {
                if (viewPager.currentItem == viewPager.adapter.count - 1) {
                    viewPager.currentItem = 0
                } else {
                    viewPager.currentItem = viewPager.currentItem + 1
                }
            }
        }
    }
}
