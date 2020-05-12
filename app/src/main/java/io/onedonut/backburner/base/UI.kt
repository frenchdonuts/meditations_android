package io.onedonut.backburner.base

import io.reactivex.Observable

interface UI<Event, State> {
    fun events(): Observable<Event>
    fun render(states: Observable<State>)
}