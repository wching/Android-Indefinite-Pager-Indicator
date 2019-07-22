package com.rbrooks.indefinitepagerindicatorsample.viewPagerSample

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.PagerNumberPickerDialogPreference
import com.rbrooks.indefinitepagerindicatorsample.util.PhotoItem

class ViewPagerAdapter(private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(context).inflate(R.layout.viewholder_image_card, container, false)
        val photoItem = PhotoItem.values()[position]

        view.findViewById<ImageView>(R.id.card_imageview).setImageResource(photoItem.photoId)
        view.findViewById<TextView>(R.id.card_title).setText(photoItem.nameId)
        view.findViewById<TextView>(R.id.card_location).setText(photoItem.locationId)
        view.findViewById<Button>(R.id.card_see_original_button)
            .setOnClickListener { openLink(photoItem.link) }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, someObject: Any) {
        container.removeView(someObject as View)
    }

    override fun isViewFromObject(view: View, someObject: Any): Boolean = view == someObject

    override fun getCount(): Int = PreferenceManager.getDefaultSharedPreferences(context).getInt(
        PagerNumberPickerDialogPreference.KEY_NUM_PAGES,
        PagerNumberPickerDialogPreference.DEFAULT_PAGES
    )

    private fun openLink(link: Uri) {
        context.startActivity(Intent(Intent.ACTION_VIEW, link))
    }
}
