package com.example.meditations.meditations

import com.example.meditations.model.Meditation
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

interface VM {
    //
    sealed class Msg {
        data class MeditationsLoaded(val meditations: List<Meditation>) : Msg()
        object NoOp : Msg()
    }

    //
    data class VMState(val uiState: UI.UIState = UI.UIState(),
                       val meditations: List<Meditation> = listOf())

    fun processEvents(events: Observable<UI.Event>)
    fun states(): Flowable<UI.UIState>
}