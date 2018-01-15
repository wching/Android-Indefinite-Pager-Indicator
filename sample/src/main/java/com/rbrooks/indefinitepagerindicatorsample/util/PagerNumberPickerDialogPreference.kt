package com.rbrooks.indefinitepagerindicatorsample.util

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.NumberPicker
import com.rbrooks.indefinitepagerindicatorsample.R


class PagerNumberPickerDialogPreference : DialogFragment() {

    companion object {
        val KEY_NUM_PAGES = "num_pages"

        val MIN_PAGES = 0
        val MAX_PAGES = PhotoItem.values().size
        val DEFAULT_PAGES = 3
    }

    private lateinit var numberPicker: NumberPicker

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = PreferenceManager.getDefaultSharedPreferences(activity)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = View.inflate(activity, R.layout.dialog_pager_number_picker, null)

        bindViews(view)
        setupViews()

        return AlertDialog.Builder(activity)
                .setTitle(R.string.pager_number_picker_dialog_title)
                .setView(view)
                .setPositiveButton(R.string.pager_number_picker_dialog_positive_text, { dialog, which ->
                    preferences.edit().putInt(KEY_NUM_PAGES, numberPicker.value).apply()
                    (activity as OnPagerNumberChangeListener).onPagerNumberChanged()
                    dismiss()
                })
                .setNegativeButton(R.string.pager_number_picker_dialog_negative_text, { dialog, which -> dismiss() })
                .create()
    }

    private fun bindViews(view: View) {
        numberPicker = view.findViewById(R.id.pager_number_dialog_number_picker)
    }

    private fun setupViews() {
        numberPicker.minValue = MIN_PAGES
        numberPicker.maxValue = MAX_PAGES
        numberPicker.value = preferences.getInt(KEY_NUM_PAGES, DEFAULT_PAGES)
    }
}