/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uxlibrary_example.horizontalselectorexample

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.realwear.uxlibrary_example.R
import com.realwear.uxlibrary_example.databinding.FragmentHorizontalSelectorBinding
import java.lang.ref.WeakReference

/**
 * Example showing the Horizontal Selector in the context of a fragment.
 */
class FragmentHorizontalSelectorExample : AppCompatActivity(), DialogInterface.OnDismissListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    private var _binding: FragmentHorizontalSelectorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var centerBorderVisibility = View.VISIBLE
    private lateinit var weakContext: WeakReference<Context>

    /**
     * Used to store the context of the dialogFragment for later use
     */
    override fun onAttach(context: Context) {
        weakContext = WeakReference(context)
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()

        val horizontalFragment: Dialog = requireDialog()
        val params: WindowManager.LayoutParams? = horizontalFragment.window?.attributes

        params?.let {
            it.width = ViewGroup.LayoutParams.MATCH_PARENT
            it.height = ViewGroup.LayoutParams.MATCH_PARENT
        }
        horizontalFragment.window?.attributes = params
    }

    /**
     * Need to use the context stored to avoid context issues from not having a clear context or wrappers.
     * For example, a dialog fragment with no layout in an activity does not pass the correct context to
     * inflate from, instead we get a contextThemeWrapper which cannot be used to attach the lifecycle behavior
     * or attach the ViewPagerFragmentPageAdapter
     */
    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHorizontalSelectorBinding.inflate(
            LayoutInflater.from(weakContext.get()),
            container,
            false
        )
        val view = binding.root

        binding.horizontalSelector.setAdapter(ExampleAdapter(weakContext.get()!!))

        /**
         * Method demonstrating how to get the index of the focused item.
         */
        binding.buttonFocusedIndex.setOnClickListener {
            Toast.makeText(
                context,
                "Focused Item Index: ${binding.horizontalSelector.focusedItemIndex}",
                Toast.LENGTH_SHORT
            ).show()
        }

        /**
         * Method demonstrating how to select a list item by index.
         */
        binding.buttonSelectItem5.setOnClickListener {
            binding.horizontalSelector.selectListItem(5)
        }

        /**
         * Method demonstrating how to deselect the currently selected list item.
         */
        binding.buttonDeselectItem.setOnClickListener {
            binding.horizontalSelector.deselectListItem()
        }

        /**
         * Method demonstrating how to change the visibility of the center border view.
         */
        binding.buttonCenterBorderVisibility.setOnClickListener {
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

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (activity is DialogInterface.OnDismissListener) {
            (activity as DialogInterface.OnDismissListener).onDismiss(dialog)
        }
    }
}