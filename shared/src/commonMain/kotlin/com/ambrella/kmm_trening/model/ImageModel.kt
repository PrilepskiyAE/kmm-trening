package com.ambrella.kmm_trening.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageModel (
    val author: String,
    val category: String,
    val path: String
)