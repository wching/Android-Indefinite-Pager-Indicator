package com.rbrooks.indefinitepagerindicatorsample

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample.RecyclerViewSampleFragment
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener
import com.rbrooks.indefinitepagerindicatorsample.util.PagerNumberPickerDialogPreference
import com.rbrooks.indefinitepagerindicatorsample.rtlViewPagerSample.RTLViewPagerSampleFragment
import com.rbrooks.indefinitepagerindicatorsample.viewPagerSample.ViewPagerSampleFragment
import kotlinx.android.synthetic.main.activity_main.toolbar


class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener,
    OnPagerNumberChangeListener {

    companion object {
        const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        const val isVerticalIndicatorKeyPreference = "isVerticalIndicatorKeyPreference"
    }

    private lateinit var tabLayout: TabLayout
    private lateinit var fragmentLayout: FrameLayout
    private lateinit var viewPagerSampleFragment: ViewPagerSampleFragment
    private lateinit var recyclerViewSampleFragment: RecyclerViewSampleFragment
    private lateinit var rtlViewPagerSampleFragment: RTLViewPagerSampleFragment
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE)

        with(toolbar as Toolbar) {
            setSupportActionBar(this)
            title = getString(R.string.main_activity_title)
            setTitleTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
        }

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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_horizontal -> {
                saveNewActionSelection(false)
                restartApp()
            }
            R.id.action_vertical -> {
                saveNewActionSelection(true)
                restartApp()
            }
            R.id.action_quantity_button -> {
                PagerNumberPickerDialogPreference().show(fragmentManager, null)
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
            1 -> setFragment(recyclerViewSampleFragment)
            2 -> setFragment(rtlViewPagerSampleFragment)
        }
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        // Do Nothing
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        // Do Nothing
    }

    override fun onPagerNumberChanged() {
        (viewPagerSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
        (recyclerViewSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
        (rtlViewPagerSampleFragment as OnPagerNumberChangeListener).onPagerNumberChanged()
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
        recyclerViewSampleFragment = RecyclerViewSampleFragment()
        rtlViewPagerSampleFragment = RTLViewPagerSampleFragment()
    }

    private fun setFragment(fragment: Fragment) {
        // TODO: Set custom animations depending on which one
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
        baseContext.packageManager
            .getLaunchIntentForPackage(baseContext.packageName)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).run {
                startActivity(this)
            }
    }
}
