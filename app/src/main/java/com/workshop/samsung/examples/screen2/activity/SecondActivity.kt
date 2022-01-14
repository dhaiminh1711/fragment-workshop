package com.workshop.samsung.examples.screen2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.workshop.samsung.R
import com.workshop.samsung.databinding.ActivitySecondBinding
import com.workshop.samsung.examples.screen2.fragment.ReceiverFragment
import com.workshop.samsung.examples.screen2.fragment.SenderFragment
import com.workshop.samsung.examples.utils.LogUtils

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private var senderFragment: SenderFragment? = null
    private var receiverFragment: ReceiverFragment? = null

    private val senderFragmentListener = object : SenderFragment.SenderFragmentListener {
        override fun sendMessage(message: String) {
            (supportFragmentManager.findFragmentByTag(RECEIVER_FRAGMENT_TAG) as ReceiverFragment).receiveMessage(message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (senderFragment == null) {
            senderFragment = SenderFragment.newInstance().also {
                it.senderFragmentListener = senderFragmentListener
            }

            supportFragmentManager.beginTransaction()
                .add(binding.senderFragmentContainer.id, senderFragment!!, SENDER_FRAGMENT_TAG)
                .commit()
        }

        if (receiverFragment == null) {
            receiverFragment = ReceiverFragment.newInstance()

            supportFragmentManager.beginTransaction()
                .add(binding.receiverFragmentContainer.id, receiverFragment!!, RECEIVER_FRAGMENT_TAG)
                .commit()
        }
    }

    companion object {
        private const val SENDER_FRAGMENT_TAG = "senderFragment"
        private const val RECEIVER_FRAGMENT_TAG = "receiverFragment"
    }
}
