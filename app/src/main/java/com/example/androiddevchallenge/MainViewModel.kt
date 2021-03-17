package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _destination = MutableLiveData<Destination>()
    val destination: LiveData<Destination>
        get() = _destination

    fun updateDestination(destination: Destination) {
        _destination.value = destination
    }
}

enum class Destination {
    Welcome,
    Login,
    Home
}
