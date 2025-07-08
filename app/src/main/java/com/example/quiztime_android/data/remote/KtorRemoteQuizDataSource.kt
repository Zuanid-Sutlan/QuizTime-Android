package com.example.quiztime_android.data.remote

import android.util.Log
import com.example.quiztime_android.domain.utils.DataError
import com.example.quiztime_android.domain.utils.Result
import com.example.quiztime_android.data.remote.dto.IssueReportDto
import com.example.quiztime_android.data.remote.dto.QuizQuestionDto
import com.example.quiztime_android.data.remote.dto.QuizTopicDto
import com.example.quiztime_android.data.util.Constant.BASE_URL
import com.example.quiztime_android.domain.utils.Error
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class KtorRemoteQuizDataSource(
    private val httpClient: HttpClient
) : RemoteQuizDataSource {

    override suspend fun getQuizTopics(): Result<List<QuizTopicDto>, DataError> {
        return safeCall<List<QuizTopicDto>> {
            httpClient.get(urlString = "$BASE_URL/quiz/topics")
        }
//        return try {
//            val response = httpClient.get(urlString = "$BASE_URL/quiz/topics")
//            val list = response.body<List<QuizTopicDto>>()
//            Result.Success(list)
//        }catch (e: Exception){
//            Log.e("KtorRemoteQuizDataSource", "getQuizTopics: $e")
//            Result.Failure(DataError.NoInternet)
//        }
    }

    override suspend fun getQuizQuestions(topicCode: Int): Result<List<QuizQuestionDto>, DataError> {
        return safeCall<List<QuizQuestionDto>> {
            httpClient.get(urlString = "$BASE_URL/quiz/questions/random") {
                parameter("topicCode", topicCode)
            }
        }
    }

    override suspend fun insertIssueReport(report: IssueReportDto): Result<Unit, DataError> {
        return safeCall<Unit> {
            httpClient.post(urlString = "$BASE_URL/report/issues") {
                setBody(report)
            }
        }
    }
}