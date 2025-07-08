package com.example.quiztime_android.presentation.screens.report

import com.example.quiztime_android.domain.model.QuizQuestion


data class IssueReportState(
    val quizQuestion: QuizQuestion? = null,
    val isQuestionCardExpanded: Boolean = false,
    val issueType: IssueType = IssueType.OTHER,
    val otherIssueText: String = "",
    val additionComment: String = "",
    val emailForFollowUp: String = "",
)

enum class IssueType(val text: String) {
    INCORRECT_ANSWER(text = "Incorrect Answer"),
    UNCLEAR_QUESTION(text = "Question is Unclear"),
    TYPO_OR_GRAMMAR(text = "Typo or Grammar Mistake"),
    OTHER(text = "Other")
}