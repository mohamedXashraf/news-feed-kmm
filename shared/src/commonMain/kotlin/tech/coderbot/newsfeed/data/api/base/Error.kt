package tech.coderbot.newsfeed.data.api.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Error (
    @SerialName("status") var status: String? = "",
    @SerialName("code") var code: String? = "",
    @SerialName("message") var message: String? = "",
)