/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.commandbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.size
import com.realwear.ux.view.CommandButton
import com.realwear.ux.viewgroup.CommandBar
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.ActivityCommandBarExampleBinding
import java.lang.IllegalArgumentException

/**
 * Example showing the Command Bar.
 */
class CommandBarExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommandBarExampleBinding
    private lateinit var secondCommandBar: CommandBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommandBarExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        secondCommandBar = CommandBar(this)
        val button1 = CommandButton(this)
        button1.text = getString(R.string.button_template, 1)
        secondCommandBar.addView(button1)
        binding.linearLayout.addView(secondCommandBar)

        setupToggleButton()
    }

    private fun setupToggleButton() {
        binding.toggleButton.setOnClickListener {
            val state = when (binding.toggleButton.isChecked) {
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

    /**
     * Add a [CommandButton] to [secondCommandBar].
     */
    @Suppress("UNUSED_PARAMETER")
    fun addButton(view: View) {
        val newButton = CommandButton(this)
        val index = secondCommandBar.size + 1
        newButton.text = getString(R.string.button_template, index)
        secondCommandBar.addView(newButton)
    }

    /**
     * Remove the last [CommandButton] from [secondCommandBar].
     */
    @Suppress("UNUSED_PARAMETER")
    fun removeButton(view: View) {
        if (secondCommandBar.size >= 1) {
            secondCommandBar.removeViewAt(secondCommandBar.size - 1)
        }
    }

    /**
     * Attempt to add a [android.widget.Button] to [secondCommandBar]. This is expected to fail to show that attempting
     * to add a non [CommandButton] type view will throw an [IllegalArgumentException].
     */
    @Suppress("UNUSED_PARAMETER")
    fun addInvalidView(view: View) {
        val invalidView = Button(this)
        try {
            secondCommandBar.addView(invalidView)
        } catch (e: IllegalArgumentException) {
            Log.e(TAG, "Attempted to add invalid type ${invalidView.javaClass} to Command Bar.", e)
            Toast.makeText(
                this,
                "Tried to add invalid view type ${invalidView.javaClass} to Command Bar. " +
                        "Only type ${CommandButton::class.java} is allowed.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        private const val TAG = "CommandBarExample"
    }
}