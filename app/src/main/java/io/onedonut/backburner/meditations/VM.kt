package io.onedonut.backburner.meditations

import androidx.lifecycle.ViewModel
import io.onedonut.backburner.base.VM
import io.onedonut.backburner.model.Meditation

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