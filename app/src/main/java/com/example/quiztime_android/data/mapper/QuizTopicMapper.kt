package com.example.quiztime_android.data.mapper

import com.example.quiztime_android.data.local.entity.QuizTopicEntity
import com.example.quiztime_android.domain.model.QuizTopic
import com.example.quiztime_android.data.remote.dto.QuizTopicDto
import com.example.quiztime_android.data.util.Constant.BASE_URL

private fun QuizTopicDto.toQuizTopic() = QuizTopic(
    id = id,
    name = name,
    imageUrl = BASE_URL + imageUrl,
    code = code
)

private fun QuizTopicDto.toQuizTopicEntity() = QuizTopicEntity(
    id = id,
    name = name,
    imageUrl = BASE_URL + imageUrl,
    code = code
)

fun QuizTopicEntity.entityToQuizTopic() = QuizTopic(
    id = id,
    name = name,
    imageUrl = imageUrl,
    code = code
)

fun List<QuizTopicDto>.toQuizTopics() = map { it.toQuizTopic() }

fun List<QuizTopicDto>.toQuizTopicsEntity() = map { it.toQuizTopicEntity() }

fun List<QuizTopicEntity>.entityToQuizTopics() = map { it.entityToQuizTopic() }