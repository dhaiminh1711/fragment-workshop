package com.workshop.samsung.examples.screen1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.workshop.samsung.databinding.ActivityMainBinding
import com.workshop.samsung.examples.screen1.fragment.FirstFragment
import com.workshop.samsung.examples.screen2.activity.SecondActivity

class MainActivity : AppCompatActivity(), FirstFragment.FirstFragmentListener {
    private lateinit var binding: ActivityMainBinding
    private var firstFragment: FirstFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (firstFragment == null) {
            firstFragment = FirstFragment.newInstance()
            supportFragmentManager.beginTransaction().add(binding.fragmentContainer.id,
                firstFragment!!, FIRST_FRAGMENT_TAG).commit()
        }

        binding.apply {
            btnNext.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun sendText(text: String) {
        Toast.makeText(this@MainActivity, "Main Activity receive a message", Toast.LENGTH_LONG).show()

        binding.apply {
            txtResult.text = text
        }
    }

    companion object {
        private const val FIRST_FRAGMENT_TAG = "firstFragment"
    }
}
