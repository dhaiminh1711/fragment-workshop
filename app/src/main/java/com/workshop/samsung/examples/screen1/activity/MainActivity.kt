package com.workshop.samsung.examples.screen1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.workshop.samsung.databinding.ActivityMainBinding
import com.workshop.samsung.examples.screen1.fragment.FirstFragment
import com.workshop.samsung.examples.screen1.viewmodel.Screen1ViewModel
import com.workshop.samsung.examples.screen2.activity.SecondActivity
import com.workshop.samsung.examples.utils.LogUtils

class MainActivity : AppCompatActivity(), FirstFragment.FirstFragmentListener {

    private lateinit var binding: ActivityMainBinding
    private var firstFragment: FirstFragment? = null
    private val screen1ViewModel: Screen1ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (firstFragment == null) {
            firstFragment = FirstFragment.newInstance()

            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainer.id, firstFragment!!, FIRST_FRAGMENT_TAG)
                .commit()
        }

        binding.apply {
            btnNext.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }

            btnClearText.setOnClickListener {
                (supportFragmentManager.findFragmentByTag(FIRST_FRAGMENT_TAG) as FirstFragment).clearText()
            }
        }

        screen1ViewModel.text.observe(this) { text ->
            Toast.makeText(this@MainActivity, "Main Activity receive a message (Observe)", Toast.LENGTH_LONG).show()

            binding.apply {
                txtResult.text = text
            }
        }
    }

    override fun onStart() {
        super.onStart()
        LogUtils.showLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.showLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.showLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.showLog("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.showLog("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.showLog("onDestroy")
    }

    override fun sendText(text: String) {
        Toast.makeText(this@MainActivity, "Main Activity receive a message (Interface)", Toast.LENGTH_LONG).show()

        binding.apply {
            txtResult.text = text
        }
    }

    companion object {
        private const val FIRST_FRAGMENT_TAG = "firstFragment"
    }
}
