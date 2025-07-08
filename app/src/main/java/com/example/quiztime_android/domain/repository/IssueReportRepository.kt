package com.example.quiztime_android.domain.repository

import com.example.quiztime_android.domain.model.IssueReport
import com.example.quiztime_android.domain.utils.DataError
import com.example.quiztime_android.domain.utils.Result

interface IssueReportRepository {

    suspend fun insertIssueReport(report: IssueReport): Result<Unit, DataError>

}