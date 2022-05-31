/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.ux.viewgroup.HorizontalSelectorAdapter
import com.realwear.ux.viewgroup.ViewHolder
import com.realwear.uxlibrary_example.R
import java.lang.ref.WeakReference

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
class ExampleAdapter(context: Context) :
    HorizontalSelectorAdapter<ExampleViewHolder>(context) {
    private val weakContext: WeakReference<Context> = WeakReference(context)
    private val localTag = ExampleAdapter::class.java.simpleName
    private var arr: Array<TestColor> = emptyArray()

    override fun onCreateViewHolder(parent: ViewGroup): ExampleViewHolder {
        return ExampleViewHolder(
            LayoutInflater.from(weakContext.get()).inflate(
                R.layout.example_view_holder,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.textView.text = "$position"
        holder.textView.setBackgroundColor(arr[position].resource)
    }

    override fun getCommand(position: Int): String {
        return arr[position].name
    }

    override fun getState(position: Int): String {
        return "#${Integer.toHexString(arr[position].resource)}"
    }

    override fun onCommand(position: Int) {
        Log.i(
            localTag,
            "Voice command triggered for position: $position"
        )
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

    fun updateArray(array: Array<TestColor>) {
        arr = array

        // FIXME: When adapter is updated from LiveData items sometimes are not fully inflated
        notifyDataSetChanged()
    }
}

/**
 * [ExampleViewHolder] is an example subclass of [ViewHolder].
 */
class ExampleViewHolder(itemView: View) : ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.text_view)
}