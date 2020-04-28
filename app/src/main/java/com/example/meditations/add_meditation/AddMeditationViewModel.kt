package com.example.meditations.add_meditation

import android.util.Log
import androidx.lifecycle.ViewModel

class AddMeditationViewModel : ViewModel() {
    init {
        Log.i("AddMeditationViewModel", "created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("AddMeditationViewModel", "onCleared")
    }
}