package com.gabhendm.maelstrom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Body (
    val type: String,
    @SerialName("node_id") val nodeId: String? = null,
    @SerialName("node_ids") val nodeIds: List<String>? = null,
    @SerialName("msg_id") val msgId: Int?,
    @SerialName("in_reply_to") val inReplyTo: Int? = null,
    @SerialName("echo") val echo: String? = null,
)
