package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import com.example.meditations.repository.MeditationRepository
import io.reactivex.Single

class InteractorsImpl(val meditationRepo: MeditationRepository) : Interactors {

    override fun fetchMeditations(): Single<List<Meditation>> {
        return meditationRepo
            .all()
            .take(1)
            .singleOrError()
    }

    companion object {
        private val TAG = "meditations:IntersImpl"
    }
}