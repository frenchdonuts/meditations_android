package com.example.meditations.add_meditation.vm

import com.example.meditations.add_meditation.interactors.Interactors
import com.example.meditations.add_meditation.ui.UI
import io.reactivex.Observable

class AddMeditationViewModel(val interactors: Interactors) : VM() {
    override fun processEvents(events: Observable<UI.Event>) {
        TODO("Not yet implemented")
    }

    override fun states(): Observable<UI.State> {
        TODO("Not yet implemented")
    }
}