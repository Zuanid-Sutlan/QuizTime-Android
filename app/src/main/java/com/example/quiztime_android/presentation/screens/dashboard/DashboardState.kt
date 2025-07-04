package com.example.quiztime_android.presentation.screens.dashboard

import com.example.quiztime_android.domain.model.QuizTopic

data class DashboardState(
    val userName: String = "Android Developer",
    val questionAttempted: Int = 10,
    val correctAnswers: Int = 7,
    val quizTopic: List<QuizTopic> = List(size = 20) { index ->
        QuizTopic(
            id = "1",
            name = "Android $index",
            imageUrl = "",
            code = 0
        )
    }
)
