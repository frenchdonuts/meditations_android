package com.example.meditations.meditations

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

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