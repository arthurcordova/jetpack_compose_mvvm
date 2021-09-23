package com.proway.jetpackcompose.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val _name = MutableLiveData("")
    val name : LiveData<String> = _name

    fun onNameChanged(newName: String) {
        _name.value = newName
    }
}