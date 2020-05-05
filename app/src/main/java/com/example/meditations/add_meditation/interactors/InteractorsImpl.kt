package com.example.meditations.add_meditation.interactors

import com.example.meditations.model.Meditation
import com.example.meditations.repository.MeditationRepository
import io.reactivex.Single

class InteractorsImpl(val meditationRepo: MeditationRepository): Interactors {

    override fun createMeditation(text: String): Single<Meditation> {
        return Single.error { TODO("Not yet implemented") }
    }

}