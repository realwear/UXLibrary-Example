/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.realwear.ux.view.ContinuousRadioButton
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.fragment_color_level.*

/**
 * Example ViewPagerFragment showcasing a Radio Group with a set of levels that can be chosen.
 */
class ColorLevelFragment(private val color: String) :
        HorizontalSelector.ViewPagerFragment(R.layout.fragment_color_level) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleButton = ContinuousRadioButton(this.requireContext())
        titleButton.text = String.format(resources.getString(R.string.color_level_fragment_text), color)
        titleButton.titleOnly = true
        color_level_radio_group.addView(titleButton)
        color_level_radio_group.dividerDrawable =
                ResourcesCompat.getDrawable(resources, R.drawable.divider_2dp, context?.theme)
        color_level_radio_group.setOnCheckedChangeListener { _, _ -> notifyFragmentAction() }

        for (i in 1..10) {
            val newButton = ContinuousRadioButton(this.requireContext())
            newButton.voiceCommand = "$color Level $i"
            newButton.text = "$i"
            color_level_radio_group.addView(newButton)
        }
    }
}
