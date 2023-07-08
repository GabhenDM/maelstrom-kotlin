package com.gabhendm.maelstrom

import kotlinx.serialization.*

@Serializable
data class Message(
    val id: Int,
    val src: String,
    val dest: String,
    val body: Body
)
