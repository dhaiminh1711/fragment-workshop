package com.workshop.samsung.examples.screen2.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.workshop.samsung.R
import com.workshop.samsung.databinding.FragmentSenderBinding
import com.workshop.samsung.examples.screen2.viewmodel.MessageViewModel

class SenderFragment : Fragment() {

    var senderFragmentListener: SenderFragmentListener? = null
    private lateinit var binding: FragmentSenderBinding
    private val messageViewModel: MessageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
//            btnSend.setOnClickListener { messageViewModel.sendMessage(binding.edtMessage.text.toString())}
            btnSend.setOnClickListener { senderFragmentListener?.sendMessage(binding.edtMessage.text.toString()) }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface SenderFragmentListener {
        fun sendMessage(message: String)
    }

    companion object {
        fun newInstance() = SenderFragment()
    }
}