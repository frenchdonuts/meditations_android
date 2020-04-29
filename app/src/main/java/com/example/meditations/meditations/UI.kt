package com.example.meditations.meditations

import io.reactivex.Flowable
import io.reactivex.Observable


interface UI {

    sealed class Event {
        object UiInitialized : Event()
        object UiRecreated : Event()
    }

    data class UIState(val items: List<Item> = listOf())

    data class Item(val id: String, val quote: String)

    fun events(): Observable<Event>
    fun render(states: Flowable<UIState>)

}