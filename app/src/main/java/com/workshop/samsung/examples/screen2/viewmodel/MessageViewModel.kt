package com.workshop.samsung.examples.screen2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {
    private val _message = MutableLiveData<String>()

    val message: LiveData<String>
        get() = _message

    fun sendMessage(message: String) {
        _message.value = message
    }
}
