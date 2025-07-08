package com.example.quiztime_android.data.mapper

import com.example.quiztime_android.domain.model.IssueReport
import com.example.quiztime_android.data.remote.dto.IssueReportDto
import com.example.quiztime_android.data.util.toFormattedDateTimeString

fun IssueReport.toIssueReportDto() = IssueReportDto(
    questionId = questionId,
    issueType = issueType,
    additionalComment = additionalComment,
    userEmail = userEmail,
    timestamp = timestampMillis.toFormattedDateTimeString()
)