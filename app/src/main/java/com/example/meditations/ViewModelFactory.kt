package com.example.meditations

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import arrow.syntax.function.memoize
import com.example.meditations.add_meditation.vm.AddMeditationViewModel
import com.example.meditations.meditations.MeditationsViewModel
import com.example.meditations.repository.MeditationRepositoryImpl
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == com.example.meditations.meditations.VM::class.java)
            return MeditationsViewModel(
                com.example.meditations.meditations.InteractorsImpl(
                    MeditationRepositoryImpl(
                        App.db
                    )
                )
            ) as T
        else if (modelClass == com.example.meditations.add_meditation.vm.VM::class.java)
            return AddMeditationViewModel(
                com.example.meditations.add_meditation.interactors.InteractorsImpl(
                    MeditationRepositoryImpl(
                        App.db
                    )
                )
            ) as T

        throw IllegalArgumentException("unknown model class: $modelClass")
    }

    companion object {
        val instance = { context: Context ->
            ViewModelFactory(context.applicationContext)
        }.memoize()
    }
}