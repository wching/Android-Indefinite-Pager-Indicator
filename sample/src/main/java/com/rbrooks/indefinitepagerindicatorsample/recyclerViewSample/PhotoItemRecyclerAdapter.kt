package com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample

import android.content.Context
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.PagerNumberPickerDialogPreference
import com.rbrooks.indefinitepagerindicatorsample.util.PhotoItem

class PhotoItemRecyclerAdapter(private val context: Context) :
    RecyclerView.Adapter<PhotoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder =
        PhotoItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.viewholder_image_card, parent, false
            )
        )

    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) =
        holder.bind(PhotoItem.values()[position])

    override fun getItemCount(): Int =
        PreferenceManager.getDefaultSharedPreferences(context).getInt(
            PagerNumberPickerDialogPreference.KEY_NUM_PAGES,
            PagerNumberPickerDialogPreference.DEFAULT_PAGES
        )
}
