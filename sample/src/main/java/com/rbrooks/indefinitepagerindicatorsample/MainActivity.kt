package com.rbrooks.indefinitepagerindicatorsample

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample.RecyclerViewSampleFragment
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener
import com.rbrooks.indefinitepagerindicatorsample.util.PagerNumberPickerDialogPreference
import com.rbrooks.indefinitepagerindicatorsample.viewPager2Sample.ViewPager2SampleFragment
import com.rbrooks.indefinitepagerindicatorsample.viewPagerSample.ViewPagerSampleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener,
    OnPagerNumberChangeListener {

    companion object {
        const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        const val isVerticalIndicatorKeyPreference = "isVerticalIndicatorKeyPreference"
    }

    private lateinit var tabLayout: TabLayout
    private lateinit var fragmentLayout: FrameLayout
    private lateinit var viewPagerSampleFragment: ViewPagerSampleFragment
    private lateinit var viewPager2SampleFragment: ViewPager2SampleFragment
    private lateinit var recyclerViewSampleFragment: RecyclerViewSampleFragment
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE)

        setSupportActionBar(toolbar)
        toolbar?.title = getString(R.string.main_activity_title)
        toolbar?.setTitleTextColor(ContextCompat.getColor(this, R.color.white))

        bindViews()
        setupFragments()
        initViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.vertical_layout_menu, menu)

        val actionIndicatorVerticalMenuItem = menu?.findItem(R.id.action_vertical)
        val actionIndicatorHorizontalMenuItem = menu?.findItem(R.id.action_horizontal)

        if (sharedPreferences.getBoolean(isVerticalIndicatorKeyPreference, false)) {
            actionIndicatorHorizontalMenuItem?.isVisible = true
        } else {
            actionIndicatorVerticalMenuItem?.isVisible = true
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_horizontal -> {
                saveNewActionSelection(false)
                restartApp()
            }
            R.id.action_vertical -> {
                saveNewActionSelection(true)
                restartApp()
            }
            R.id.action_quantity_button -> {
                PagerNumberPickerDialogPreference().show(supportFragmentManager, null)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        tabLayout.removeOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> setFragment(viewPagerSampleFragment)
            1 -> setFragment(viewPager2SampleFragment)
            2 -> setFragment(recyclerViewSampleFragment)
        }
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onPagerNumberChanged() {
        (viewPagerSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
        (viewPager2SampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
        (recyclerViewSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
    }

    // Private Api

    private fun bindViews() {
        tabLayout = findViewById(R.id.main_activity_tab_layout)
        fragmentLayout = findViewById(R.id.main_activity_fragment_holder)
    }

    private fun initViews() {
        tabLayout.addOnTabSelectedListener(this)
        setFragment(viewPagerSampleFragment)
    }

    private fun setupFragments() {
        viewPagerSampleFragment = ViewPagerSampleFragment()
        viewPager2SampleFragment = ViewPager2SampleFragment()
        recyclerViewSampleFragment = RecyclerViewSampleFragment()
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fragment_holder, fragment).commit()
    }

    private fun saveNewActionSelection(isVerticalSelected: Boolean) =
        sharedPreferences.edit()
            .putBoolean(
                isVerticalIndicatorKeyPreference,
                isVerticalSelected
            ).commit()

    private fun restartApp() {
        val intent = baseContext.packageManager
            .getLaunchIntentForPackage(baseContext.packageName)
            ?.apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
        startActivity(intent)
    }
}
