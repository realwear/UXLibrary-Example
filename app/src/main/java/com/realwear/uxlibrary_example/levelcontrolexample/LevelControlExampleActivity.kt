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
import com.realwear.uxlibrary_example.databinding.ActivityLevelControlBinding

/**
 * Example showing the Level Control.
 */
class LevelControlExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLevelControlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.levelControl.let {
            it.min = 10
            it.max = 20
            it.value = 15
            it.positiveVoiceCommand = getString(R.string.level_control_code_positive_command)
            it.negativeVoiceCommand = getString(R.string.level_control_code_negative_command)
            it.zeroVoiceCommand = getString(R.string.level_control_code_zero_command)
            it.title = getString(R.string.level_control_code_title)
            it.onLevelChangedListener = object : OnLevelChangedListener {
                override fun onLevelChanged(newLevel: Int) {
                    Log.i(TAG, "New level: $newLevel")
                }
            }
        }
    }

    companion object {
        private const val TAG = MainActivity.TAG
    }
}