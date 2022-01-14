package com.workshop.samsung.examples.screen2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.workshop.samsung.databinding.FragmentReceiverBinding
import com.workshop.samsung.examples.screen2.viewmodel.MessageViewModel

class ReceiverFragment : Fragment() {

    private lateinit var binding: FragmentReceiverBinding
    private val messageViewModel: MessageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentReceiverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        messageViewModel.message.observe(viewLifecycleOwner) { message ->
//            binding.apply {
//                txtMessage.text = message
//            }
//        }
    }

    fun receiveMessage(message: String) {
        binding.apply {
            txtMessage.text = message
        }
    }

    companion object {
        fun newInstance() = ReceiverFragment()
    }
}