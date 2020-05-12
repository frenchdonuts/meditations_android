package io.onedonut.backburner.meditations

import io.reactivex.Observable

interface Interactors {
    fun meditations(): Observable<VM.Msg>
}