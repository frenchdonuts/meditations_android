package io.onedonut.backburner.repository

import com.squareup.sqldelight.runtime.rx.asObservable
import com.squareup.sqldelight.runtime.rx.mapToList
import io.onedonut.backburner.Database
import io.onedonut.backburner.model.Meditation
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MeditationRepositoryImpl(val db: Database):
    MeditationRepository {
    private val queries = db.meditationQueries

    override fun all(): Observable<List<Meditation>> {
        return queries
            .selectAll()
            .asObservable(Schedulers.io())
            .mapToList()
            .map { it.map { Meditation.from(it) }  }
    }

    override fun create(text: String): Completable {
        return Completable.fromCallable {
            queries.insertMeditation(text)
        }
    }

    companion object {
        private val TAG = "MeditationRepoImpl"
    }
}