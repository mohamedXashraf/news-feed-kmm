package tech.coderbot.newsfeed.data.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import tech.coderbot.newsfeed.data.api.base.API
import tech.coderbot.newsfeed.data.api.base.Response
import tech.coderbot.newsfeed.data.model.News

object NewsAPIs: API() {
    suspend fun getArticles(source: String): Response<News> {
        val response = engine.get("$baseUrl/articles") {
            url {
                parameters.append("source", source)
                parameters.append("apiKey", apiKey)
            }
        }.bodyAsText()
        return fromJson(response)
    }
}