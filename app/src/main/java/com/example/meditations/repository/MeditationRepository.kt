package com.example.meditations.repository

import com.example.meditations.model.Meditation
import io.reactivex.Completable
import io.reactivex.Observable

interface MeditationRepository {
    fun all(): Observable<List<Meditation>>
    fun create(text: String): Completable
}