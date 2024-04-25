package com.ambrella.kmm_trening

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform