package com.example.quiztime_android.presentation.screens.dashboard

sealed interface DashboardAction {
    data object NameEditIconClick: DashboardAction
    data object NameEditDialogDismiss: DashboardAction
    data object NameEditDialogConfirm: DashboardAction
    data class SetUsername(val username: String) : DashboardAction
    data object RefreshIconClick: DashboardAction
}