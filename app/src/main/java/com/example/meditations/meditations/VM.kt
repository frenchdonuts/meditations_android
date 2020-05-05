package com.example.meditations.meditations

import androidx.lifecycle.ViewModel
import com.example.meditations.base.VM
import com.example.meditations.model.Meditation

abstract class VM: VM<UI.Event, UI.State>, ViewModel() {
    //
    sealed class Msg {
        data class MeditationsLoaded(val meditations: List<Meditation>) : Msg()
        object NoOp : Msg()
    }

    //
    data class State(
        val uiState: UI.State = UI.State(),
        val meditations: List<Meditation> = listOf()
    )

}