package com.example.quiztime_android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quiztime_android.data.util.Constant.QUIZ_TOPIC_TABLE_NAME

@Entity(tableName = QUIZ_TOPIC_TABLE_NAME)
data class QuizTopicEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val imageUrl: String,
    val code: Int
)
