/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example.moreoptionsexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.realwear.ux.view.CommandButton
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.ActivityMoreOptionsBinding

/**
 * Example showing the More Options widget.
 */
class MoreOptionsExampleActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMoreOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button used to show that we can't interact with the underlying view when More Options is displayed
        binding.option1Button.setOnClickListener(this)

        val contentForMoreOptions = layoutInflater.inflate(
            R.layout.more_options_content,
            findViewById(android.R.id.content),
            false
        )

        binding.moreOptionsWidget.setContentView(contentForMoreOptions)

        // Button from the layout that we add to the More Options widget
        contentForMoreOptions.findViewById<CommandButton>(R.id.option2Button)
            .setOnClickListener(this)

        // Button from the layout that we add to the More Options widget
        contentForMoreOptions.findViewById<CommandButton>(R.id.option3Button)
            .setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v is Button) {
            Toast.makeText(this, v.text, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Method to show, then hide, the more options view when view [v] is clicked.
     */
    @Suppress("UNUSED_PARAMETER")
    fun openProgrammaticallyClick(v: View?) {
        // Show the More Options tray.
        binding.moreOptionsWidget.showMoreOptions()
        // Hide the More Options tray after 2 seconds.
        binding.moreOptionsWidget.postDelayed({ binding.moreOptionsWidget.hideMoreOptions() }, 2000)
    }
}