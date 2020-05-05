package com.example.meditations.add_meditation.interactors

import com.example.meditations.model.Meditation
import io.reactivex.Single

interface Interactors {
    fun createMeditation(text: String): Single<Meditation>
}