package tech.coderbot.newsfeed.android.application

import tech.coderbot.newsfeed.data.repository.NewsRepositoryImplementation
import tech.coderbot.newsfeed.domain.repository.NewsRepository
import tech.coderbot.newsfeed.domain.usecase.FilterArticles
import tech.coderbot.newsfeed.domain.usecase.GetAllArticles
import tech.coderbot.newsfeed.domain.usecase.GetNewsById
import tech.coderbot.newsfeed.android.presentation.details.DetailsViewModel
import tech.coderbot.newsfeed.android.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {

    single<NewsRepository> { NewsRepositoryImplementation() }

    single { GetAllArticles(get()) }

    single { GetNewsById(get()) }

    single { FilterArticles(get()) }

    viewModel { HomeViewModel(get(), get()) }

    viewModel { DetailsViewModel(get()) }
}