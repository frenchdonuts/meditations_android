package com.example.meditations.repository

import com.example.meditations.model.Meditation
import io.reactivex.Observable

interface MeditationRepository {
    fun all(): Observable<List<Meditation>>
}