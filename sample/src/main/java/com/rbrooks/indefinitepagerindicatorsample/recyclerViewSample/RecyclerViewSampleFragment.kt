package com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator
import com.rbrooks.indefinitepagerindicatorsample.MainActivity
import com.rbrooks.indefinitepagerindicatorsample.MainActivity.Companion.isVerticalIndicatorKeyPreference
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener

class RecyclerViewSampleFragment : Fragment(), OnPagerNumberChangeListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pagerIndicator: IndefinitePagerIndicator
    private lateinit var pagerIndicatorHorizontal: IndefinitePagerIndicator
    private var isVerticalEnabled = false

    private var recyclerViewAdapter: PhotoItemRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recyclerview_sample, container, false)

        context?.let {
            isVerticalEnabled = it.getSharedPreferences(
                MainActivity.SHARED_PREFERENCES,
                AppCompatActivity.MODE_PRIVATE
            ).getBoolean(
                isVerticalIndicatorKeyPreference,
                false
            )
        }

        bindViews(view)
        setupViews()

        return view
    }

    private fun bindViews(view: View) {
        with(view) {
            recyclerView = findViewById(R.id.recyclerview)
            pagerIndicator = findViewById(R.id.recyclerview_pager_indicator)
            pagerIndicatorHorizontal = findViewById(R.id.recyclerview_pager_indicator_horizontal)
        }
    }

    private fun setupViews() {
        context?.let {
            recyclerViewAdapter = PhotoItemRecyclerAdapter(it)
            recyclerView.adapter = recyclerViewAdapter
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            if (isVerticalEnabled) {
                pagerIndicator.attachToRecyclerView(recyclerView)
                pagerIndicator.visibility = View.VISIBLE
            } else {
                pagerIndicatorHorizontal.attachToRecyclerView(recyclerView)
                pagerIndicatorHorizontal.visibility = View.VISIBLE
            }
        }
    }

    override fun onPagerNumberChanged() {
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}