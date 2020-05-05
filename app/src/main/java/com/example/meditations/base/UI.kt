package com.example.meditations.base

import io.reactivex.Observable

interface UI<Event, State> {
    fun events(): Observable<Event>
    fun render(states: Observable<State>)
}