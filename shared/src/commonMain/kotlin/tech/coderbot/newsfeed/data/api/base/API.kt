package tech.coderbot.newsfeed.data.api.base

import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

abstract class API {
    val baseUrl = "https://newsapi.org/v1/"
    val apiKey: String
        get() = "91da53ae90924e6981690f1c3128ef89"
    val engine = HttpClient {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    inline fun <reified T> fromJson(json: String, ): T = Json.decodeFromString(json)

    fun toJson(data: Any) = Json.encodeToString(data)
}