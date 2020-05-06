package com.example.meditations.add_meditation.interactors

import com.example.meditations.add_meditation.vm.VM
import io.reactivex.Single

interface Interactors {
    fun createMeditation(text: String): Single<VM.Msg>
}