package com.ambrella.kmm_trening.ui.state

import com.ambrella.kmm_trening.common.Action

interface MainAction : Action {
    data class SelectCategory(val category: String): MainAction

}