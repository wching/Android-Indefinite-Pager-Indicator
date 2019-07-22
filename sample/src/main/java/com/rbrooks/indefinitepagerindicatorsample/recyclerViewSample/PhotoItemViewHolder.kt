package com.rbrooks.indefinitepagerindicatorsample.recyclerViewSample

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rbrooks.indefinitepagerindicatorsample.R
import com.rbrooks.indefinitepagerindicatorsample.util.PhotoItem

class PhotoItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(photoItem: PhotoItem) {
        itemView.findViewById<ImageView>(R.id.card_imageview).setImageResource(photoItem.photoId)
        itemView.findViewById<TextView>(R.id.card_title).setText(photoItem.nameId)
        itemView.findViewById<TextView>(R.id.card_location).setText(photoItem.locationId)
        itemView.findViewById<Button>(R.id.card_see_original_button)
            .setOnClickListener { openLink(photoItem.link) }
    }

    private fun openLink(link: Uri) {
        itemView.context.startActivity(Intent(Intent.ACTION_VIEW, link))
    }
}