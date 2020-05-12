package io.onedonut.backburner.add_meditation.ui

interface UI:
    io.onedonut.backburner.base.UI<UI.Event, UI.State> {
    //
    sealed class Event {
        data class CreateButtonTapped(val meditationText: String) : Event()
        object UIInitialized : Event()
    }

    //
    data class State(val unit: Unit = Unit)

}