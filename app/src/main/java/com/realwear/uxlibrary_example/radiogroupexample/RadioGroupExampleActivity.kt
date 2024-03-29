/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example.radiogroupexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.realwear.ux.view.ContinuousRadioButton
import com.realwear.ux.view.RadioButton
import com.realwear.ux.view.RoundRadioButton
import com.realwear.uxlibrary_example.MainActivity
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.ActivityRadioGroupBinding

/**
 * Example showing the Radio Group.
 */
class RadioGroupExampleActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var binding: ActivityRadioGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continuousRadioGroupJava.let {
            it.setOnCheckedChangeListener(this)
            it.addView(
                createContinuousRadioButton(
                    getString(R.string.radio_group_java_continuous_button_1)
                )
            )
            it.addView(
                createContinuousRadioButton(
                    getString(R.string.radio_group_java_continuous_button_2)
                )
            )
            it.addView(
                createContinuousRadioButton(
                    getString(R.string.radio_group_java_continuous_button_3)
                )
            )
        }

        binding.roundRadioGroupJava.let {
            it.setOnCheckedChangeListener(this)
            it.addView(
                createRoundRadioButton(
                    getString(R.string.radio_group_java_round_button_1)
                )
            )
            it.addView(
                createRoundRadioButton(
                    getString(R.string.radio_group_java_round_button_2)
                )
            )
            it.addView(
                createRoundRadioButton(
                    getString(R.string.radio_group_java_round_button_3)
                )
            )
        }

    }

    /**
     * Create and set up a ContinuousRadioButton that displays the input [text].
     */
    private fun createContinuousRadioButton(text: String): ContinuousRadioButton {
        val continuousRadioButton = ContinuousRadioButton(this)
        continuousRadioButton.text = text
        continuousRadioButton.setOnClickListener { view: View -> onRadioButtonClicked(view) }
        return continuousRadioButton
    }

    /**
     * Create and set up a RoundRadioButton that displays the input [text].
     */
    private fun createRoundRadioButton(text: String): RoundRadioButton {
        val roundRadioButton = RoundRadioButton(this)
        roundRadioButton.text = text
        roundRadioButton.setOnClickListener { view: View -> onRadioButtonClicked(view) }
        return roundRadioButton
    }

    /**
     * Handler for when a radio button [view] is clicked.
     */
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            Log.i(MainActivity.TAG, "Radio button clicked: " + view.text)
        }
    }

    override fun onCheckedChanged(radioGroup: RadioGroup, index: Int) {
        val button: RadioButton = radioGroup.findViewById(index)
        Log.i(MainActivity.TAG, "Radio button checked: " + button.text)
    }
}