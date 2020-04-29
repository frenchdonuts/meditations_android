package com.example.meditations.meditations

import com.example.meditations.Database
import com.example.meditations.model.Meditation
import com.squareup.sqldelight.runtime.rx.asObservable
import com.squareup.sqldelight.runtime.rx.mapToList
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class InteractorsImpl(val db: Database) : Interactors {
    override fun fetchMeditations(): Single<List<Meditation>> {
        return db.meditationQueries
            .selectAll()
            .asObservable(Schedulers.io())
            .mapToList()
            .map { it.map { Meditation.from(it) }  }
            .singleOrError()
    }
}