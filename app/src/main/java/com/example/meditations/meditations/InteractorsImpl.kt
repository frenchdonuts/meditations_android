package com.example.meditations.meditations

import com.example.meditations.repository.MeditationRepository
import io.reactivex.Observable

class InteractorsImpl(val meditationRepo: MeditationRepository) : Interactors {

    override fun meditations(): Observable<VM.Msg> {
        return meditationRepo.all()
            .map { VM.Msg.MeditationsLoaded(it) }
    }

    companion object {
        private val TAG = "meditations:IntersImpl"
    }
}