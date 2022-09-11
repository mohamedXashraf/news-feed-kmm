package tech.coderbot.newsfeed.android.presentation.home

import tech.coderbot.newsfeed.domain.usecase.FilterArticles
import tech.coderbot.newsfeed.domain.usecase.GetAllArticles
import tech.coderbot.newsfeed.android.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val getAllArticles: GetAllArticles, private val filterArticles: FilterArticles) : BaseViewModel<HomeViewState, HomeViewIntent>()
{
    init
    {
        observeIntents {
            when (it)
            {
                is HomeViewIntent.GetAllArticles -> getAllArticles()
                is HomeViewIntent.FilterArticles -> filter(it.query)
            }
        }
    }

    private fun getAllArticles() = CoroutineScope(Dispatchers.IO).launch {
        state.postValue(HomeViewState.LoadingState)
        try
        {
            state.postValue(HomeViewState.DataState(getAllArticles.run()))
        }
        catch (ex: Throwable)
        {
            ex.printStackTrace()
            state.postValue(HomeViewState.ErrorState(ex))
        }
    }

    private fun filter(query: String) = CoroutineScope(Dispatchers.IO).launch {
        val filteredArticles = filterArticles.run(query)
        state.postValue(HomeViewState.DataState(filteredArticles))
    }
}