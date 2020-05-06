package com.example.meditations.add_meditation.interactors

import com.example.meditations.add_meditation.vm.VM
import com.example.meditations.repository.MeditationRepository
import io.reactivex.Single

class InteractorsImpl(val meditationRepo: MeditationRepository): Interactors {

    override fun createMeditation(text: String): Single<VM.Msg> {
        return meditationRepo.create(text).toSingleDefault(VM.Msg.NoOp)
    }

}