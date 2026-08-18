package org.ucb.appp2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform