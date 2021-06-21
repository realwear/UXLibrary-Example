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
import kotlinx.android.synthetic.main.activity_command_bar_example.*
import java.lang.IllegalArgumentException

/**
 * Example showing the Command Bar.
 */
class CommandBarExampleActivity : AppCompatActivity() {
    private lateinit var secondCommandBar: CommandBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_bar_example)

        secondCommandBar = CommandBar(this)
        val button1 = CommandButton(this)
        button1.text = getString(R.string.button_template, 1)
        secondCommandBar.addView(button1)
        linear_layout.addView(secondCommandBar)
    }

    /**
     * Add a [CommandButton] to [secondCommandBar].
     */
    fun addButton(view: View) {
        val newButton = CommandButton(this)
        val index = secondCommandBar.size + 1
        newButton.text = getString(R.string.button_template, index)
        secondCommandBar.addView(newButton)
    }

    /**
     * Remove the last [CommandButton] from [secondCommandBar].
     */
    fun removeButton(view: View) {
        if (secondCommandBar.size >= 1) {
            secondCommandBar.removeViewAt(secondCommandBar.size - 1)
        }
    }

    /**
     * Attempt to add a [android.widget.Button] to [secondCommandBar]. This is expected to fail to show that attempting
     * to add a non [CommandButton] type view will throw an [IllegalArgumentException].
     */
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