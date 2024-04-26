package com.ambrella.kmm_trening.ui.state

import androidx.compose.runtime.Immutable
import com.ambrella.kmm_trening.common.State
import com.ambrella.kmm_trening.common.emptyString
import com.ambrella.kmm_trening.model.ImageModel

interface MainState : State {
    @Immutable
    data class Data(
        val images: List<ImageModel> = emptyList(),
        val selectedCategory: String = emptyString()
    ):MainState
}