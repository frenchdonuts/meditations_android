package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import io.reactivex.Observable

interface Interactors {
    fun meditations(): Observable<List<Meditation>>
}