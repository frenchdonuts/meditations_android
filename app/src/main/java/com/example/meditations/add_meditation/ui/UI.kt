package com.example.meditations.add_meditation.ui

interface UI: com.example.meditations.base.UI<UI.Event, UI.State> {
    //
    sealed class Event {
        data class CreateButtonTapped(val meditationText: String) : Event()
        object UIInitialized : Event()
    }

    //
    data class State(val unit: Unit = Unit)

}