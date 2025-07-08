package com.example.quiztime_android.domain.repository

import com.example.quiztime_android.domain.model.QuizQuestion
import com.example.quiztime_android.domain.model.UserAnswer
import com.example.quiztime_android.domain.utils.DataError
import com.example.quiztime_android.domain.utils.Result

interface QuizQuestionRepository {

    suspend fun fetchAndSaveQuizQuestions(topicCode: Int): Result<List<QuizQuestion>, DataError>

    suspend fun getQuizQuestions(): Result<List<QuizQuestion>, DataError>

    suspend fun getQuizQuestionById(questionId: String): Result<QuizQuestion, DataError>

    suspend fun saveUserAnswers(userAnswers: List<UserAnswer>): Result<Unit, DataError>

    suspend fun getUserAnswers(): Result<List<UserAnswer>, DataError>

}