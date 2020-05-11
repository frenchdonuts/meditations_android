package com.example.meditations.meditations

import io.reactivex.Observable

interface Interactors {
    fun meditations(): Observable<VM.Msg>
}