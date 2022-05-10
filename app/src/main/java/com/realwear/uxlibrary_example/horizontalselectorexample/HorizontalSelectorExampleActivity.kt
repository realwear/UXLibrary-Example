/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.ActivityHorizontalSelectorBinding

/**
 * Example showing the Horizontal Selector.
 */
class HorizontalSelectorExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHorizontalSelectorBinding
    private var centerBorderVisibility = View.VISIBLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalSelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.horizontalSelector.setAdapter(ExampleAdapter(this))
    }

    /**
     * Method demonstrating how to get the index of the focused item.
     */
    @Suppress("UNUSED_PARAMETER")
    fun getFocusedIndex(view: View) {
        Toast.makeText(
            this,
            "Focused Item Index: ${binding.horizontalSelector.focusedItemIndex}",
            Toast.LENGTH_SHORT
        )
            .show()
    }

    /**
     * Method demonstrating how to select a list item by index.
     */
    @Suppress("UNUSED_PARAMETER")
    fun setSelectedItem(view: View) {
        binding.horizontalSelector.selectListItem(5)
    }

    /**
     * Method demonstrating how to deselect the currently selected list item.
     */
    @Suppress("UNUSED_PARAMETER")
    fun deselectItem(view: View) {
        binding.horizontalSelector.deselectListItem()
    }

    /**
     * Method demonstrating how to change the visibility of the center border view.
     */
    @Suppress("UNUSED_PARAMETER")
    fun switchCenterBorderVisibility(view: View) {
        if (centerBorderVisibility == View.VISIBLE) {
            binding.horizontalSelector.setCenterBorderVisibility(View.GONE)
            centerBorderVisibility = View.GONE
            binding.buttonCenterBorderVisibility.text = getString(R.string.insert_border)
        } else {
            binding.horizontalSelector.setCenterBorderVisibility(View.VISIBLE)
            centerBorderVisibility = View.VISIBLE
            binding.buttonCenterBorderVisibility.text = getString(R.string.remove_border)
        }
    }
}
