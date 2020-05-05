package com.example.meditations.add_meditation.vm

import androidx.lifecycle.ViewModel
import com.example.meditations.add_meditation.ui.UI

abstract class VM: com.example.meditations.base.VM<UI.Event, UI.State>, ViewModel() {
}