package tech.coderbot.newsfeed.domain.usecase

import tech.coderbot.newsfeed.domain.repository.NewsRepository

class GetNewsById constructor(private val repository: NewsRepository) {

    fun run(id: String) = repository.getCachedArticles().find { it.id == id }
}