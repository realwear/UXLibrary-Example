/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example.buttonsexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.realwear.uxlibrary_example.databinding.ActivityCommandButtonBinding

/**
 * Example showing the Command Button.
 */
class CommandButtonExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommandButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommandButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.selectedTextButton.isSelected = true

        setupToggleButton()
    }

    private fun setupToggleButton() {
        binding.toggleButton.setOnClickListener {
            val state = when(binding.toggleButton.isChecked) {
                true -> "Test toggle button is checked"
                false -> "Test Toggle button is unchecked"
            }
            Toast.makeText(
                applicationContext,
                state,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}