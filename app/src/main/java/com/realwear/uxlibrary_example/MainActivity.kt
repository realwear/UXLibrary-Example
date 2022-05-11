/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.realwear.uxlibrary_example.commandbarexample.CommandBarExampleActivity
import com.realwear.uxlibrary_example.buttonsexample.CommandButtonExampleActivity
import com.realwear.uxlibrary_example.horizontalselectorexample.HorizontalSelectorOptionActivity
import com.realwear.uxlibrary_example.levelcontrolexample.LevelControlExampleActivity
import com.realwear.uxlibrary_example.moreoptionsexample.MoreOptionsExampleActivity
import com.realwear.uxlibrary_example.radiogroupexample.RadioGroupExampleActivity
import com.realwear.uxlibrary_example.textviewexample.StyledTextViewExampleActivity

/**
 * Main activity that is shown when the UX Library Example App is launched.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Launch activity for command button example.
     */
    fun commandButtonExampleClick(v: View) {
        startActivity(Intent(v.context, CommandButtonExampleActivity::class.java))
    }

    /**
     * Launch activity for level control example.
     */
    fun levelControlExampleClick(v: View) {
        startActivity(Intent(v.context, LevelControlExampleActivity::class.java))
    }

    /**
     * Launch activity for horizontal selector example.
     */
    fun horizontalSelectorExampleClick(v: View) {
        startActivity(Intent(v.context, HorizontalSelectorOptionActivity::class.java))
    }

    /**
     * Launch activity for more options example.
     */
    fun moreOptionsExampleClick(v: View) {
        startActivity(Intent(v.context, MoreOptionsExampleActivity::class.java))
    }

    /**
     * Launch activity for styled text view example.
     */
    fun styledTextViewExampleClick(v: View) {
        startActivity(Intent(v.context, StyledTextViewExampleActivity::class.java))
    }

    /**
     * Launch activity for radio group example.
     */
    fun radioGroupExampleClick(v: View) {
        startActivity(Intent(v.context, RadioGroupExampleActivity::class.java))
    }

    /**
     * Launch activity for command bar example.
     */
    fun commandBarClick(v: View) {
        startActivity(Intent(v.context, CommandBarExampleActivity::class.java))
    }

    companion object {
        const val TAG = "UXLIBEX"
    }
}