package tech.coderbot.newsfeed.data.api.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    @SerialName("status") var status: String? = "",
    @SerialName("source") var source: String? = "",
    @SerialName("sortBy") var sortBy: String? = "",
    @SerialName("articles") var articles: MutableList<T>? = mutableListOf()
)