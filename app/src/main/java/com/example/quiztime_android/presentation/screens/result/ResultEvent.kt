package com.example.quiztime_android.presentation.screens.result

sealed interface ResultEvent {
    data class ShowToast(val message: String) : ResultEvent
}