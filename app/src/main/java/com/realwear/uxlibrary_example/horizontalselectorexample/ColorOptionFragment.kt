/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.os.Bundle
import android.view.View
import com.realwear.ux.view.ContinuousRadioButton
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.fragment_color_option.*

/**
 * Example ViewPagerFragment showcasing a Radio Group with various options that can be chosen.
 */
class ColorOptionFragment(private val color: String) :
        HorizontalSelector.ViewPagerFragment(R.layout.fragment_color_option) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color_option_radio_group.setOnCheckedChangeListener { _, _ -> notifyFragmentAction() }

        val option1 = ContinuousRadioButton(this.requireContext())
        option1.text = String.format(resources.getString(R.string.color_option_fragment_text_1), color)
        color_option_radio_group.addView(option1)

        val option2 = ContinuousRadioButton(this.requireContext())
        option2.text = String.format(resources.getString(R.string.color_option_fragment_text_2), color)
        color_option_radio_group.addView(option2)
    }
}
