package com.example.compose_layout_practice_140621.bottomnavigationbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _currentScreen = MutableLiveData<Screens>(Screens.HomeScreen.Mails)
    var currentScreen: LiveData<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }

}