package com.example.quiztime_android.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class QuizTopicDto(
    val id: String,
    val name: String,
    val imageUrl: String,
    val code: Int
)
