package com.example.quiztime_android.data.repository

import com.example.quiztime_android.data.mapper.toIssueReportDto
import com.example.quiztime_android.data.remote.RemoteQuizDataSource
import com.example.quiztime_android.domain.model.IssueReport
import com.example.quiztime_android.domain.repository.IssueReportRepository
import com.example.quiztime_android.domain.utils.DataError
import com.example.quiztime_android.domain.utils.Result

class IssueReportRepositoryImpl(
    private val remoteDataSource: RemoteQuizDataSource
): IssueReportRepository {

    override suspend fun insertIssueReport(
        report: IssueReport
    ): Result<Unit, DataError> {
        val reportDto = report.toIssueReportDto()
        return remoteDataSource.insertIssueReport(reportDto)
    }

}