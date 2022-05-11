/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.realwear.ux.view.ContinuousRadioButton
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.FragmentColorLevelBinding

/**
 * Example ViewPagerFragment showcasing a Radio Group with a set of levels that can be chosen.
 */
class ColorLevelFragment(private val color: String) :
    HorizontalSelector.ViewPagerFragment(R.layout.fragment_color_level) {
    private var _binding: FragmentColorLevelBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentColorLevelBinding.inflate(inflater, container, false)
        val view = binding.root

        val titleButton = ContinuousRadioButton(this.requireContext())
        titleButton.text =
            String.format(resources.getString(R.string.color_level_fragment_text), color)
        titleButton.titleOnly = true

        val colorLevelRadioGroup = binding.colorLevelRadioGroup

        colorLevelRadioGroup.addView(titleButton)
        colorLevelRadioGroup.dividerDrawable =
            ResourcesCompat.getDrawable(resources, R.drawable.divider_2dp, context?.theme)
        colorLevelRadioGroup.setOnCheckedChangeListener { _, _ -> notifyFragmentAction() }

        for (i in 1..10) {
            val newButton = ContinuousRadioButton(this.requireContext())
            newButton.voiceCommand = "$color Level $i"
            newButton.text = "$i"
            colorLevelRadioGroup.addView(newButton)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
