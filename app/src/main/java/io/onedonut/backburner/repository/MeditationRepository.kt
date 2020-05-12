package io.onedonut.backburner.repository

import io.onedonut.backburner.model.Meditation
import io.reactivex.Completable
import io.reactivex.Observable

interface MeditationRepository {
    fun all(): Observable<List<Meditation>>
    fun create(text: String): Completable
}