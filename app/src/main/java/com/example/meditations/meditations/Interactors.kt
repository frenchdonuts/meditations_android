package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import io.reactivex.rxjava3.core.Single

interface Interactors {
    fun fetchMeditations(): Single<List<Meditation>>
}