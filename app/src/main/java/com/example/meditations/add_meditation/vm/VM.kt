package com.example.meditations.add_meditation.vm

import androidx.lifecycle.ViewModel
import com.example.meditations.add_meditation.ui.UI

abstract class VM: com.example.meditations.base.VM<UI.Event, UI.State>, ViewModel() {
    sealed class Msg {
        object NoOp : Msg()
    }
    data class State(val uiState: UI.State = UI.State())
}