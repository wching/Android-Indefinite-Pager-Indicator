package com.rbrooks.indefinitepagerindicatorsample.viewPager2Sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rbrooks.indefinitepagerindicatorsample.MainActivity
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.databinding.FragmentViewPager2SampleBinding
import com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample.PhotoItemRecyclerAdapter
import com.rbrooks.indefinitepagerindicatorsample.util.OnPagerNumberChangeListener

class ViewPager2SampleFragment : Fragment(), OnPagerNumberChangeListener, View.OnClickListener {

    private var isVerticalEnabled = false

    private var pagerAdapter: PhotoItemRecyclerAdapter? = null

    private var _binding: FragmentViewPager2SampleBinding? = null
    private val binding: FragmentViewPager2SampleBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentViewPager2SampleBinding.inflate(inflater, container, false)

        isVerticalEnabled = requireContext().getSharedPreferences(
            MainActivity.SHARED_PREFERENCES,
            androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
        ).getBoolean(
            MainActivity.isVerticalIndicatorKeyPreference,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        pagerAdapter = PhotoItemRecyclerAdapter(requireContext())

        with(binding) {
            viewPager.adapter = pagerAdapter
            if (isVerticalEnabled) {
                verticalViewPagerIndicator.attachToViewPager2(viewPager)
                verticalViewPagerIndicator.visibility = View.VISIBLE
            } else {
                horizontalViewPagerIndicator.attachToViewPager2(viewPager)
                horizontalViewPagerIndicator.visibility = View.VISIBLE
            }

            previousButton.setOnClickListener(this@ViewPager2SampleFragment)
            nextButton.setOnClickListener(this@ViewPager2SampleFragment)
        }
    }

    override fun onPagerNumberChanged() {
        pagerAdapter?.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        with(binding) {
            val adapter = requireNotNull(viewPager.adapter)
            when (v?.id) {
                R.id.previous_button -> {
                    if (viewPager.currentItem == 0) {
                        viewPager.currentItem = adapter.itemCount - 1
                    } else {
                        viewPager.currentItem = viewPager.currentItem - 1
                    }
                }
                R.id.next_button -> {
                    if (viewPager.currentItem == adapter.itemCount - 1) {
                        viewPager.currentItem = 0
                    } else {
                        viewPager.currentItem = viewPager.currentItem + 1
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        pagerAdapter = null
    }
}
