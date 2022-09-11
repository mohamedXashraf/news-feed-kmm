package tech.coderbot.newsfeed.domain.repository

import tech.coderbot.newsfeed.data.model.News

interface NewsRepository {

    suspend fun getNextWebArticles(): MutableList<News>

    suspend fun getAssociatedPressArticles(): MutableList<News>

    fun getCachedArticles(): MutableList<News>
}