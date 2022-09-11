package tech.coderbot.newsfeed.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class News(
    var id: String? = uid(),
    @SerialName("author") var author: String? = "",
    @SerialName("title") var title: String? = "",
    @SerialName("description") var description: String? = "",
    @SerialName("url") var url: String? = "",
    @SerialName("urlToImage") var urlToImage: String? = "",
    @SerialName("publishedAt") var publishedAt: String? = ""
)


private fun uid(): String {
    var uid = ""
    val pool = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    (1..100).forEach { _ ->
        uid = "$uid${pool.random()}"
    }
    return uid
}
