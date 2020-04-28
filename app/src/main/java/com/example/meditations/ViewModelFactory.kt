package com.example.meditations

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import arrow.syntax.function.memoize
import com.example.meditations.meditations.InteractorsImpl
import com.example.meditations.meditations.MeditationsViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MeditationsViewModel::class.java)
            return MeditationsViewModel(InteractorsImpl()) as T

        throw IllegalArgumentException("unknown model class: $modelClass")
    }

    companion object {
        val instance = { context: Context ->
            ViewModelFactory(context.applicationContext)
        }.memoize()
    }
}