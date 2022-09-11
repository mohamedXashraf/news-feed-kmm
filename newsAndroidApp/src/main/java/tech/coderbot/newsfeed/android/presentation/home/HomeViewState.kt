package tech.coderbot.newsfeed.android.presentation.home

import tech.coderbot.newsfeed.data.model.News

sealed class HomeViewState {
    object ViewInitializationState : HomeViewState()
    class DataState(val news: MutableList<News>) : HomeViewState()
    class ErrorState(val error: Throwable) : HomeViewState()
    object LoadingState : HomeViewState()
}