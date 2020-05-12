package io.onedonut.backburner.add_meditation.interactors

import io.onedonut.backburner.add_meditation.vm.VM
import io.onedonut.backburner.repository.MeditationRepository
import io.reactivex.Single

class InteractorsImpl(val meditationRepo: MeditationRepository):
    Interactors {

    override fun createMeditation(text: String): Single<VM.Msg> {
        return meditationRepo.create(text).toSingleDefault(VM.Msg.NoOp)
    }

}