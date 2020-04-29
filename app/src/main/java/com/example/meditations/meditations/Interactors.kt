package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import io.reactivex.Single

interface Interactors {
    fun fetchMeditations(): Single<List<Meditation>>
}