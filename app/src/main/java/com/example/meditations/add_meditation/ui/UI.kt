package com.example.meditations.add_meditation.ui

interface UI: com.example.meditations.base.UI<UI.Event, UI.State> {
    //
    sealed class Event {
        object createButtonTapped : Event()
    }
    sealed class State() {
        //
    }
}