/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example.levelcontrolexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.realwear.ux.view.LevelControl.OnLevelChangedListener
import com.realwear.uxlibrary_example.MainActivity
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.activity_level_control.*

/**
 * Example showing the Level Control.
 */
class LevelControlExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_control)

        level_control.min = 10
        level_control.max = 20
        level_control.value = 15
        level_control.positiveVoiceCommand = getString(R.string.level_control_code_positive_command)
        level_control.negativeVoiceCommand = getString(R.string.level_control_code_negative_command)
        level_control.zeroVoiceCommand = getString(R.string.level_control_code_zero_command)
        level_control.title = getString(R.string.level_control_code_title)
        level_control.onLevelChangedListener = object : OnLevelChangedListener {
            override fun onLevelChanged(newLevel: Int) {
                Log.i(TAG, "New level: $newLevel")
            }
        }
    }

    companion object {
        private const val TAG = MainActivity.TAG
    }
}