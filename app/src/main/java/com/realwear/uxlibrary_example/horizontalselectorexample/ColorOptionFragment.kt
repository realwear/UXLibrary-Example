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
import com.realwear.ux.view.ContinuousRadioButton
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.FragmentColorOptionBinding

/**
 * Example ViewPagerFragment showcasing a Radio Group with various options that can be chosen.
 */
class ColorOptionFragment(private val color: String) :
    HorizontalSelector.ViewPagerFragment(R.layout.fragment_color_option) {
    private var _binding: FragmentColorOptionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentColorOptionBinding.inflate(inflater, container, false)
        val view = binding.root

        val colorOptionRadioGroup = binding.colorOptionRadioGroup

        colorOptionRadioGroup.setOnCheckedChangeListener { _, _ -> notifyFragmentAction() }

        val option1 = ContinuousRadioButton(this.requireContext())
        option1.text =
            String.format(resources.getString(R.string.color_option_fragment_text_1), color)
        colorOptionRadioGroup.addView(option1)

        val option2 = ContinuousRadioButton(this.requireContext())
        option2.text =
            String.format(resources.getString(R.string.color_option_fragment_text_2), color)
        colorOptionRadioGroup.addView(option2)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
