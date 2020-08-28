/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */
package com.realwear.uxlibrary_example.moreoptionsexample

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.activity_more_options.*
import kotlinx.android.synthetic.main.more_options_content.view.*
import java.lang.ref.WeakReference

/**
 * Example showing the More Options widget.
 */
class MoreOptionsExampleActivity : AppCompatActivity(), View.OnClickListener {
    private val moreOptionsHandler = MoreOptionsHandler(WeakReference<MoreOptionsExampleActivity>(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_options)

        // Button used to show that we can't interact with the underlying view when More Options is displayed
        option1Button.setOnClickListener(this)
        val contentForMoreOptions = layoutInflater.inflate(
                R.layout.more_options_content,
                findViewById(android.R.id.content),
                false)

        // Button from the layout that we add to the More Options widget
        contentForMoreOptions.option2Button.setOnClickListener(this)

        // Button from the layout that we add to the More Options widget
        contentForMoreOptions.option3Button.setOnClickListener(this)
        moreOptionsWidget?.setContentView(contentForMoreOptions)
    }

    override fun onClick(v: View) {
        if (v is Button) {
            Toast.makeText(this, v.text, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Method to show, then hide, the more options view when view [v] is clicked.
     */
    fun openProgrammaticallyClick(v: View?) {
        if (moreOptionsWidget != null) {
            // Show the More Options tray.
            moreOptionsWidget.showMoreOptions()
            // Hide the More Options tray after 2 seconds.
            moreOptionsHandler.sendEmptyMessageDelayed(0, 2000)
        }
    }

    /**
     * Handler to manage hiding the More Options tray.
     */
    class MoreOptionsHandler(private val outerClass: WeakReference<MoreOptionsExampleActivity>) : Handler() {
        override fun handleMessage(msg: Message) {
            outerClass.get()?.moreOptionsWidget?.hideMoreOptions()
        }
    }
}