package com.rbrooks.indefinitepagerindicatorsample.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import com.rbrooks.indefinitepagerindicatorsample.MainActivity
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample.PhotoItemRecyclerAdapter
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener

class ViewPager2Fragment : Fragment(), OnPagerNumberChangeListener {

    private lateinit var viewpager2: ViewPager2
    private lateinit var pagerIndicator: IndefinitePagerIndicator
    private lateinit var pagerIndicatorHorizontal: IndefinitePagerIndicator
    private var isVerticalEnabled = false

    private var recyclerViewAdapter: PhotoItemRecyclerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_viewpager2_sample, container, false)

        isVerticalEnabled = requireContext().getSharedPreferences(MainActivity.SHARED_PREFERENCES, AppCompatActivity.MODE_PRIVATE)
            .getBoolean(MainActivity.isVerticalIndicatorKeyPreference, false)

        bindViews(view)
        setupViews()

        return view
    }

    private fun bindViews(view: View) {
        with(view) {
            viewpager2 = findViewById(R.id.viewpager2)
            pagerIndicator = findViewById(R.id.recyclerview_pager_indicator)
            pagerIndicatorHorizontal = findViewById(R.id.recyclerview_pager_indicator_horizontal)
        }
    }

    private fun setupViews() {
        recyclerViewAdapter = PhotoItemRecyclerAdapter(requireContext())
        viewpager2.adapter = recyclerViewAdapter
        if (isVerticalEnabled) {
            pagerIndicator.attachToViewPager(viewpager2)
            pagerIndicator.visibility = View.VISIBLE
        } else {
            pagerIndicatorHorizontal.attachToViewPager(viewpager2)
            pagerIndicatorHorizontal.visibility = View.VISIBLE
        }
    }

    override fun onPagerNumberChanged() {
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}