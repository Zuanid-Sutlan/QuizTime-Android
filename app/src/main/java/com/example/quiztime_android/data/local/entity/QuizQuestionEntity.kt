package com.example.quiztime_android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quiztime_android.data.util.Constant.QUIZ_QUESTION_TABLE_NAME

@Entity(tableName = QUIZ_QUESTION_TABLE_NAME)
data class QuizQuestionEntity(
    @PrimaryKey
    val id: String,
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val explanation: String,
    val topicCode: Int
)
