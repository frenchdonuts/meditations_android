package io.onedonut.backburner.add_meditation.interactors

import io.onedonut.backburner.add_meditation.vm.VM
import io.reactivex.Single

interface Interactors {
    fun createMeditation(text: String): Single<VM.Msg>
}