package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import io.reactivex.Single

class InteractorsImpl : Interactors {
    override fun fetchMeditations(): Single<List<Meditation>> {
        return Single.just(listOf(
            Meditation("1", "aaaaaaaa"),
            Meditation("2", "bbbbbbbb"),
            Meditation("3", "cccccccc")
        ))
    }
}