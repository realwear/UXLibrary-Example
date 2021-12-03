/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.realwear.ux.viewgroup.HorizontalSelector
import com.realwear.ux.viewgroup.HorizontalSelectorAdapter
import com.realwear.ux.viewgroup.ViewHolder
import com.realwear.uxlibrary_example.R
import kotlinx.android.synthetic.main.fragment_horizontal_selector.view.*
import java.lang.ref.WeakReference

/**
 * Example showing the Horizontal Selector in the context of a fragment.
 */
class FragmentHorizontalSelectorExample : AppCompatActivity(), DialogInterface.OnDismissListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)

        CustomDialogFragment().show(
            supportFragmentManager, "DialogFragmentExample"
        )
    }

    override fun onDismiss(dialog: DialogInterface?) {
        this.finish()
    }
}

/**
 * Class for the CustomDialogFragment
 */
class CustomDialogFragment : DialogFragment() {
    private lateinit var weakContext: WeakReference<Context>

    /**
     * Used to store the context of the dialogFragment for later use
     */
    override fun onAttach(context: Context) {
        weakContext = WeakReference(context)
        super.onAttach(context)
    }

    /**
     * Need to use the context stored to avoid context issues from not having a clear context or wrappers.
     * For example, a dialog fragment with no layout in an activity does not pass the correct context to
     * inflate from, instead we get a contextThemeWrapper which cannot be used to attach the lifecycle behavior
     * or attach the ViewPagerFragmentPageAdapter
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentInflater = LayoutInflater.from(weakContext.get())
        val view = fragmentInflater.inflate(R.layout.fragment_horizontal_selector, container, false)
        view.horizontal_selector.setAdapter(ExampleAdapter(weakContext.get()!!))
        return view
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (activity is DialogInterface.OnDismissListener) {
            (activity as DialogInterface.OnDismissListener).onDismiss(dialog)
        }
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
    inner class ExampleAdapter(context: Context) :
        HorizontalSelectorAdapter<ExampleViewHolder>(context) {
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
            return ExampleViewHolder(
                layoutInflater.inflate(
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

        override fun getCommand(position: Int): String? {
            return arr[position].name
        }

        override fun getState(position: Int): String? {
            return "#${Integer.toHexString(arr[position].resource)}"
        }

        override fun onCommand(position: Int) {
            Log.i(
                HorizontalSelectorExampleActivity::class.simpleName,
                "Voice command triggered for position: $position"
            )
            this@CustomDialogFragment.dismiss()
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
}