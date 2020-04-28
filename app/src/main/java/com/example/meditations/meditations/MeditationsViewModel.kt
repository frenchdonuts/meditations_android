package com.example.meditations.meditations

import androidx.lifecycle.ViewModel
import arrow.syntax.function.pipe
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

class MeditationsViewModel(val interactors: Interactors) : ViewModel(), VM {

    private fun toMsgs(events: Observable<UI.Event>): Observable<VM.Msg> = events.publish { shared ->
        Observable.merge(listOf(
            shared.ofType(UI.Event.UiInitialized::class.java)
                .switchMapSingle { interactors.fetchMeditations() }
                .map { VM.Msg.MeditationsLoaded(it) },
            shared.ofType(UI.Event.UiRecreated::class.java)
                .map { VM.Msg.NoOp }
        ))
    }

    private fun computeStates(msgs: Observable<VM.Msg>): Observable<VM.VMState> = msgs.scan(VM.VMState(),
        { state, msg ->
            when (msg) {
                is VM.Msg.MeditationsLoaded -> {
                    val items = msg.meditations
                        .map { UI.Item(it.id, it.text) }
                    state.copy(uiState = state.uiState.copy(items = items))
                }
                is VM.Msg.NoOp -> state
            }
        })

    private val eventsSubject: PublishSubject<UI.Event> = PublishSubject.create()
    private val statesSubject: BehaviorSubject<UI.UIState> = BehaviorSubject.create()
    private val uiInitializedFilter =
        BiFunction { _ : UI.Event, newEvent: UI.Event ->
        if (newEvent is UI.Event.UiInitialized) {
            UI.Event.UiRecreated
        } else {
            newEvent
        }
    }

    init {
        eventsSubject
            .scan(uiInitializedFilter)
            .pipe { toMsgs(it) }
            .pipe { computeStates(it) }
            .map { it.uiState }
            .subscribe(statesSubject)
    }
    override fun processEvents(events: Observable<UI.Event>) {
        events.subscribe(eventsSubject)
    }

    override fun states(): Flowable<UI.UIState> {
        return statesSubject.toFlowable(BackpressureStrategy.LATEST)
    }
}