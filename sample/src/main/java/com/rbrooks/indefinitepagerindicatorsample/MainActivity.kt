package com.rbrooks.indefinitepagerindicatorsample

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import android.widget.ImageButton
import com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample.RecyclerViewSampleFragment
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener
import com.rbrooks.indefinitepagerindicatorsample.util.PagerNumberPickerDialogPreference
import com.rbrooks.indefinitepagerindicatorsample.viewPagerSample.ViewPagerSampleFragment

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener, OnPagerNumberChangeListener {

    private lateinit var pagerQuantityButton: ImageButton
    private lateinit var tabLayout: TabLayout
    private lateinit var fragmentLayout: FrameLayout
    private lateinit var viewPagerSampleFragment: ViewPagerSampleFragment
    private lateinit var recyclerViewSampleFragment: RecyclerViewSampleFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        setupFragments()
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        tabLayout.removeOnTabSelectedListener(this)
    }

    private fun bindViews() {
        pagerQuantityButton = findViewById(R.id.main_activity_pager_quantity_button)
        tabLayout = findViewById(R.id.main_activity_tab_layout)
        fragmentLayout = findViewById(R.id.main_activity_fragment_holder)
    }

    private fun initViews() {
        pagerQuantityButton.setOnClickListener({ PagerNumberPickerDialogPreference().show(fragmentManager, null) })
        tabLayout.addOnTabSelectedListener(this)
        setFragment(viewPagerSampleFragment)
    }

    private fun setupFragments() {
        viewPagerSampleFragment = ViewPagerSampleFragment()
        recyclerViewSampleFragment = RecyclerViewSampleFragment()
    }

    private fun setFragment(fragment: Fragment) {
        // TODO: Set custom animations depending on which one
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_fragment_holder, fragment).commit()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> setFragment(viewPagerSampleFragment)
            1 -> setFragment(recyclerViewSampleFragment)
        }
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onPagerNumberChanged() {
        (viewPagerSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
        (recyclerViewSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
    }
}
