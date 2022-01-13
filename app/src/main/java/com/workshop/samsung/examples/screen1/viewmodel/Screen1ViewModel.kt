package com.workshop.samsung.examples.screen1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Screen1ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    fun changeText(text: String) {
        _text.value = text
    }
}
