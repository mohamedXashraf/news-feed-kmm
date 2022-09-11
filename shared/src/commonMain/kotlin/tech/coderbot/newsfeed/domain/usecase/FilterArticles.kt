package tech.coderbot.newsfeed.domain.usecase

import tech.coderbot.newsfeed.domain.repository.NewsRepository

class FilterArticles constructor(private val repository: NewsRepository) {

    fun run(query: String) = repository.getCachedArticles().filter {
        val qry = query.lowercase()
        it.title?.lowercase()?.contains(qry) == true || it.author?.lowercase()?.contains(qry) == true
    }.toMutableList()
}