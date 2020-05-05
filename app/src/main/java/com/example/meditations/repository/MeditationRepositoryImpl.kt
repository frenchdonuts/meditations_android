package com.example.meditations.repository

import com.example.meditations.Database
import com.example.meditations.model.Meditation
import com.squareup.sqldelight.runtime.rx.asObservable
import com.squareup.sqldelight.runtime.rx.mapToList
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MeditationRepositoryImpl(val db: Database): MeditationRepository {

    override fun all(): Observable<List<Meditation>> {
        return db.meditationQueries
            .selectAll()
            .asObservable(Schedulers.io())
            .mapToList()
            .map { it.map { Meditation.from(it) }  }
    }

}