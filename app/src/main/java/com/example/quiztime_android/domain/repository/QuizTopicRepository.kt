package com.example.quiztime_android.domain.repository

import com.example.quiztime_android.domain.model.QuizTopic
import com.example.quiztime_android.domain.utils.DataError
import com.example.quiztime_android.domain.utils.Result

interface QuizTopicRepository {

    suspend fun getQuizTopics(): Result<List<QuizTopic>, DataError>

    suspend fun getQuizTopicByCode(topicCode: Int): Result<QuizTopic, DataError>

}