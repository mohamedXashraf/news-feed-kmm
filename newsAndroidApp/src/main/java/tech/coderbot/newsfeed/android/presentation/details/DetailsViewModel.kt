package tech.coderbot.newsfeed.android.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.coderbot.newsfeed.domain.usecase.GetNewsById
import tech.coderbot.newsfeed.data.model.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel constructor(private val getNewsById: GetNewsById) : ViewModel() {

    val news = MutableLiveData<News>()

    fun getNewsById(id: String) = CoroutineScope(Dispatchers.IO).launch {
        news.postValue(getNewsById.run(id))
    }
}