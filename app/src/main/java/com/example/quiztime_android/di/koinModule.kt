package com.example.quiztime_android.di

import com.example.quiztime_android.data.local.DataStoreFactory
import com.example.quiztime_android.data.local.DatabaseFactory
import com.example.quiztime_android.data.local.QuizDatabase
import com.example.quiztime_android.data.remote.HttpClientFactory
import com.example.quiztime_android.data.remote.KtorRemoteQuizDataSource
import com.example.quiztime_android.data.remote.RemoteQuizDataSource
import com.example.quiztime_android.data.repository.IssueReportRepositoryImpl
import com.example.quiztime_android.data.repository.QuizQuestionRepositoryImpl
import com.example.quiztime_android.data.repository.QuizTopicRepositoryImpl
import com.example.quiztime_android.data.repository.UserPreferencesRepositoryImpl
import com.example.quiztime_android.domain.repository.IssueReportRepository
import com.example.quiztime_android.domain.repository.QuizQuestionRepository
import com.example.quiztime_android.domain.repository.QuizTopicRepository
import com.example.quiztime_android.domain.repository.UserPreferencesRepository
import com.example.quiztime_android.presentation.screens.dashboard.DashboardViewModel
import com.example.quiztime_android.presentation.screens.quiz.QuizViewModel
import com.example.quiztime_android.presentation.screens.report.IssueReportViewModel
import com.example.quiztime_android.presentation.screens.result.ResultViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {

    //remote
    single { HttpClientFactory.create() }
    singleOf(::KtorRemoteQuizDataSource).bind<RemoteQuizDataSource>()

    //local
    single { DataStoreFactory.create(get()) }
    single { DatabaseFactory.create(get()) }
    single { get<QuizDatabase>().quizTopicDao() }
    single { get<QuizDatabase>().quizQuestionDao() }
    single { get<QuizDatabase>().userAnswerDao() }

    //Repository
    singleOf(::QuizQuestionRepositoryImpl).bind<QuizQuestionRepository>()
    singleOf(::QuizTopicRepositoryImpl).bind<QuizTopicRepository>()
    singleOf(::IssueReportRepositoryImpl).bind<IssueReportRepository>()
    singleOf(::UserPreferencesRepositoryImpl).bind<UserPreferencesRepository>()

    //ViewModel
    viewModelOf(::QuizViewModel)
    viewModelOf(::DashboardViewModel)
    viewModelOf(::ResultViewModel)
    viewModelOf(::IssueReportViewModel)

}