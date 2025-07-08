package com.example.quiztime_android.data.mapper

import com.example.quiztime_android.data.local.entity.QuizQuestionEntity
import com.example.quiztime_android.domain.model.QuizQuestion
import com.example.quiztime_android.data.remote.dto.QuizQuestionDto

private fun QuizQuestionDto.toQuizQuestion() = QuizQuestion(
    id = id,
    topicCode = topicCode,
    question = question,
    correctAnswer = correctAnswer,
    allOptions = (incorrectAnswers + correctAnswer).shuffled(),
    explanation = explanation
)

private fun QuizQuestionDto.toQuizQuestionEntity() = QuizQuestionEntity(
    id = id,
    topicCode = topicCode,
    question = question,
    correctAnswer = correctAnswer,
    incorrectAnswers = incorrectAnswers,
    explanation = explanation
)

fun QuizQuestionEntity.entityToQuizQuestion() = QuizQuestion(
    id = id,
    topicCode = topicCode,
    question = question,
    correctAnswer = correctAnswer,
    allOptions = (incorrectAnswers + correctAnswer).shuffled(),
    explanation = explanation
)

fun List<QuizQuestionDto>.toQuizQuestions() = map { it.toQuizQuestion() }

fun List<QuizQuestionDto>.toQuizQuestionsEntity() = map { it.toQuizQuestionEntity() }

fun List<QuizQuestionEntity>.entityToQuizQuestions() = map { it.entityToQuizQuestion() }