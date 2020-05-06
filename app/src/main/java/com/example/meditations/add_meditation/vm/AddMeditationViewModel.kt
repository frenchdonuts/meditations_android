package com.example.meditations.add_meditation.vm

import com.example.meditations.add_meditation.interactors.Interactors
import com.example.meditations.add_meditation.ui.UI
import io.reactivex.Observable

class AddMeditationViewModel(val interactors: Interactors) : VM() {
    override fun processEvents(events: Observable<UI.Event>) {
        //
    }

    override fun states(): Observable<UI.State> {
        return Observable.empty()
    }
}