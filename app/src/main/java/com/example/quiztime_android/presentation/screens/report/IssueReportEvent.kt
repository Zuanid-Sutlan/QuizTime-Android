package com.example.quiztime_android.presentation.screens.report

sealed interface IssueReportEvent {
    data class ShowToast(val message: String) : IssueReportEvent
    data object NavigateUp : IssueReportEvent
}