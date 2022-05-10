/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.realwear.uxlibrary_example.R

/**
 * Activity for selecting the relevant horizontal selector example
 */
class HorizontalSelectorOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horizontal_selector_base_activity)
    }

    /**
     * Launch activity for Fragment horizontal selector example.
     */
    fun fragmentExampleClick(v: View) {
        startActivity(Intent(v.context, FragmentHorizontalSelectorExample::class.java))
    }

    /**
     * Launch activity for Activity horizontal selector example.
     */
    fun activityExampleClick(v: View) {
        startActivity(Intent(v.context, HorizontalSelectorExampleActivity::class.java))
    }
}