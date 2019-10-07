package com.rbrooks.indefinitepagerindicatorsample

import androidx.viewpager.widget.ViewPager

fun ViewPager.scrollToNextPage() {
    currentItem = (currentItem + 1).coerceAtMost(lastIndex)
}

fun ViewPager.scrollToPreviousPage() {
    currentItem = (currentItem - 1).coerceAtLeast(0)
}

val ViewPager.lastIndex: Int
    get() = (adapter?.count ?: 0 - 1).coerceAtLeast(0)