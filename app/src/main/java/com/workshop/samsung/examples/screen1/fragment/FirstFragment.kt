package com.workshop.samsung.examples.screen1.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.workshop.samsung.databinding.FragmentFirstBinding
import com.workshop.samsung.examples.screen1.viewmodel.Screen1ViewModel

class FirstFragment : Fragment() {
    /* With the help of Interface
        Step 1: Create an interface in fragment class
        Step 2: Implement the interface in activity class
        Step 3: Call the interface method from fragment class
        Step 4: Set listener variable to null when fragment is detached
    */

    private var firstFragmentListener: FirstFragmentListener? = null
    private lateinit var binding: FragmentFirstBinding
    private val screen1ViewModel: Screen1ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnInterfaceSubmit.setOnClickListener {
                firstFragmentListener?.sendText(binding.edtMessage.text.toString())
            }

            btnObserveSubmit.setOnClickListener {
                screen1ViewModel.changeText(binding.edtMessage.text.toString())
            }
        }
    }

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

    fun clearText() {
        binding.edtMessage.text = null
    }

    interface FirstFragmentListener {
        fun sendText(text: String)
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}
