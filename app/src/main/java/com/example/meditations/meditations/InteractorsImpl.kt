package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import com.example.meditations.repository.MeditationRepository
import io.reactivex.Observable

class InteractorsImpl(val meditationRepo: MeditationRepository) : Interactors {

    override fun meditations(): Observable<List<Meditation>> {
        return meditationRepo.all()
    }

    companion object {
        private val TAG = "meditations:IntersImpl"
    }
}