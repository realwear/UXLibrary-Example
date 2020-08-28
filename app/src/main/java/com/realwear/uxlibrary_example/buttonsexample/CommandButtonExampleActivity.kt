/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example.buttonsexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.activity_command_button.*

/**
 * Example showing the Command Button.
 */
class CommandButtonExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_command_button)
        selected_text_button.isSelected = true
    }
}