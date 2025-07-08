package com.example.quiztime_android.data.remote

import com.example.quiztime_android.domain.utils.DataError
import com.example.quiztime_android.domain.utils.Result
import com.example.quiztime_android.data.remote.dto.IssueReportDto
import com.example.quiztime_android.data.remote.dto.QuizQuestionDto
import com.example.quiztime_android.data.remote.dto.QuizTopicDto

interface RemoteQuizDataSource {

    suspend fun getQuizTopics(): Result<List<QuizTopicDto>, DataError>

    suspend fun getQuizQuestions(topicCode: Int): Result<List<QuizQuestionDto>, DataError>

    suspend fun insertIssueReport(report: IssueReportDto): Result<Unit, DataError>
    
}