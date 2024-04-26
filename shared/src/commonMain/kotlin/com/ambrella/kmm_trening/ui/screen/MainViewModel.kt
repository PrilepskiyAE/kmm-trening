package com.ambrella.kmm_trening.ui.screen

import com.ambrella.kmm_trening.common.AbstractViewModel
import com.ambrella.kmm_trening.ui.state.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: AbstractViewModel() {
    private val _state: MutableStateFlow<MainState.Data> = MutableStateFlow(MainState.Data())

    override val state: StateFlow<MainState> = _state.asStateFlow()
}