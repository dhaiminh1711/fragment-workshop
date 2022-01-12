package com.workshop.samsung.examples.screen1.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshop.samsung.R
import com.workshop.samsung.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var firstFragmentListener: FirstFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnSubmit.setOnClickListener {
                firstFragmentListener?.sendText(binding.edtMessage.text.toString())
            }
        }
    }

    /* With the help of Interface
        Step 1: Create an interface in fragment class
        Step 2: Implement the interface in activity class
        Step 3: Call the interface method from fragment class
        Step 4: Set listener variable to null when fragment is detached
    */
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FirstFragmentListener) {
            firstFragmentListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()

        firstFragmentListener = null
    }

    interface FirstFragmentListener {
        fun sendText(text: String)
    }

    // 2. With the help of ViewModel

    companion object {
        fun newInstance() = FirstFragment()
    }
}
