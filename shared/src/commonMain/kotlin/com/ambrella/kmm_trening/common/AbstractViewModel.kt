package com.ambrella.kmm_trening.common
import com.ambrella.kmm_trening.common.Action
import com.ambrella.kmm_trening.common.State
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow
abstract class AbstractViewModel:  ViewModel() {
    abstract val state: StateFlow<State>

    open fun doAction(action: Action) = Unit
}
