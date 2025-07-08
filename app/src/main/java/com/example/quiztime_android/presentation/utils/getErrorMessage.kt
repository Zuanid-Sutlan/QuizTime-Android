package com.example.quiztime_android.presentation.utils

import com.example.quiztime_android.domain.utils.DataError

fun DataError.getErrorMessage(): String {
    return when(this) {
        DataError.NoInternet -> "No internet connection. Check your network"
        DataError.RequestTimeout -> "Request timed out. Please try again later."
        DataError.Serialization -> "Failed to process data. Try again."
        DataError.Server -> "Server error occurred. Please try again later."
        DataError.TooManyRequests -> "Too many request. Please slow down."
        is DataError.Unknown -> "An unknown error occurred. ${this.errorMessage}"
    }
}