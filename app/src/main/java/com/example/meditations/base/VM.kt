package com.example.meditations.base

import io.reactivex.Observable

interface VM<UIEvent, UIState> {
    fun processEvents(events: Observable<UIEvent>)
    fun states(): Observable<UIState>
}