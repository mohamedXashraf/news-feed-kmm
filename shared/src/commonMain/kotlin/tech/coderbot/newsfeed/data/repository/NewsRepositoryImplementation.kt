package tech.coderbot.newsfeed.data.repository

import tech.coderbot.newsfeed.data.api.NewsAPIs
import tech.coderbot.newsfeed.data.model.News
import tech.coderbot.newsfeed.domain.repository.NewsRepository

class NewsRepositoryImplementation : NewsRepository {

    private val api = NewsAPIs

    private var nextWebArticles = mutableListOf<News>()

    private var associatedPressArticles = mutableListOf<News>()

    override suspend fun getNextWebArticles(): MutableList<News> {
        val response = api.getArticles("the-next-web")
        if (response.status != null && response.status.equals("ok", ignoreCase = true)) {
            nextWebArticles = response.articles ?: mutableListOf()
        }
        return nextWebArticles
    }

    override suspend fun getAssociatedPressArticles(): MutableList<News> {
        val response = api.getArticles("associated-press")
        if (response.status != null && response.status.equals("ok", ignoreCase = true)) {
            associatedPressArticles = response.articles ?: mutableListOf()
        }
        return associatedPressArticles
    }

    override fun getCachedArticles(): MutableList<News> {
        val articles = mutableListOf<News>()
        articles.addAll(nextWebArticles)
        articles.addAll(associatedPressArticles)
        return articles
    }
}