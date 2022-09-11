package tech.coderbot.newsfeed.android.presentation.home

sealed class HomeViewIntent {
    object GetAllArticles : HomeViewIntent()
    class FilterArticles(val query: String) : HomeViewIntent()
}