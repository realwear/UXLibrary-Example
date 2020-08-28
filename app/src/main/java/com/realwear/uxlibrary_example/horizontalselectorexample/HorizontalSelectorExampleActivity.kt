/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.ux.viewgroup.HorizontalSelectorAdapter
import com.realwear.ux.viewgroup.ViewHolder
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.activity_horizontal_selector.*

/**
 * Example showing the Horizontal Selector.
 */
class HorizontalSelectorExampleActivity : AppCompatActivity() {
    private var centerBorderVisibility = View.VISIBLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_selector)
        horizontal_selector.setAdapter(ExampleAdapter(this))
    }

    /**
     * Enum class with test colors [name] and their [resource] integers.
     */
    enum class TestColor(val resource: Int) {
        Black(Color.BLACK),
        Red(Color.RED),
        Yellow(Color.YELLOW),
        Green(Color.GREEN),
        Cyan(Color.CYAN),
        Blue(Color.BLUE),
        Gray(Color.GRAY),
        White(Color.WHITE),
        Brown(Color.rgb(120, 79, 23)),
        Orange(Color.rgb(255, 127, 0)),
        Violet(Color.rgb(117, 7, 135))
    }

    /**
     * [ExampleAdapter] is an example subclass of [HorizontalSelectorAdapter].
     */
    inner class ExampleAdapter(context: Context) : HorizontalSelectorAdapter<ExampleViewHolder>(context) {
        private val arr = arrayOf(
            TestColor.Black,
            TestColor.Brown,
            TestColor.Red,
            TestColor.Orange,
            TestColor.Yellow,
            TestColor.Green,
            TestColor.Cyan,
            TestColor.Blue,
            TestColor.Violet,
            TestColor.Gray,
            TestColor.White
        )

        override fun onCreateViewHolder(parent: ViewGroup): ExampleViewHolder {
            return ExampleViewHolder(layoutInflater.inflate(R.layout.example_view_holder, parent, false))
        }

        override fun getItemCount(): Int {
            return arr.size
        }

        override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
            holder.textView.text = "$position"
            holder.textView.setBackgroundColor(arr[position].resource)
        }

        override fun getCommand(position: Int): String? {
            return arr[position].name
        }

        override fun getState(position: Int): String? {
            return "#${Integer.toHexString(arr[position].resource)}"
        }

        override fun onCommand(position: Int) {
            Log.i(
                HorizontalSelectorExampleActivity::class.simpleName,
                    "Voice command triggered for position: $position")
        }

        override fun getViewPagerFragment(position: Int): HorizontalSelector.ViewPagerFragment? {
            //
            // An example of how to set distinct ViewPagerFragments to different positions. The first
            // and second list items will use custom ViewPagerFragments, and the rest will return null
            // to produce default behavior (no fragment appears on selection).
            //
            return when (position) {
                0 -> ColorOptionFragment(arr[position].name)
                1 -> ColorLevelFragment(arr[position].name)
                else -> null
            }
        }
    }

    /**
     * [ExampleViewHolder] is an example subclass of [ViewHolder].
     */
    inner class ExampleViewHolder(itemView: View) : ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    /**
     * Method demonstrating how to get the index of the focused item.
     */
    fun getFocusedIndex(view: View) {
        Toast.makeText(this,
                "Focused Item Index: ${horizontal_selector.focusedItemIndex}",
                Toast.LENGTH_SHORT)
                .show()
    }

    /**
     * Method demonstrating how to select a list item by index.
     */
    fun setSelectedItem(view: View) {
        horizontal_selector.selectListItem(5)
    }

    /**
     * Method demonstrating how to deselect the currently selected list item.
     */
    fun deselectItem(view: View) {
        horizontal_selector.deselectListItem()
    }

    /**
     * Method demonstrating how to change the visibility of the center border view.
     */
    fun switchCenterBorderVisibility(view: View) {
        if (centerBorderVisibility == View.VISIBLE) {
            horizontal_selector.setCenterBorderVisibility(View.GONE)
            centerBorderVisibility = View.GONE
            button_center_border_visibility.text = getString(R.string.insert_border)
        } else {
            horizontal_selector.setCenterBorderVisibility(View.VISIBLE)
            centerBorderVisibility = View.VISIBLE
            button_center_border_visibility.text = getString(R.string.remove_border)
        }
    }
}
