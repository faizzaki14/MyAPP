package com.faizzakiramadhan_19104075.myapplication.ui.Profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "TOLONGGGG"
    }
    val text: LiveData<String> = _text
}