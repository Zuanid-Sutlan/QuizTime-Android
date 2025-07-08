package com.example.quiztime_android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quiztime_android.data.local.converter.OptionListConverters
import com.example.quiztime_android.data.local.dao.QuizQuestionDao
import com.example.quiztime_android.data.local.dao.QuizTopicDao
import com.example.quiztime_android.data.local.dao.UserAnswerDao
import com.example.quiztime_android.data.local.entity.QuizQuestionEntity
import com.example.quiztime_android.data.local.entity.QuizTopicEntity
import com.example.quiztime_android.data.local.entity.UserAnswerEntity

@Database(
    version = 3,
    entities = [
        QuizTopicEntity::class,
        QuizQuestionEntity::class,
        UserAnswerEntity::class
    ]
)
@TypeConverters(
    OptionListConverters::class
)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizTopicDao(): QuizTopicDao

    abstract fun quizQuestionDao(): QuizQuestionDao

    abstract fun userAnswerDao(): UserAnswerDao

}