package com.example.quiztime_android.presentation.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiztime_android.presentation.components.dashboard.StatisticsCard

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(text = "Hello", style = MaterialTheme.typography.bodyMedium)
        Row{
            Text(text = "Android Developer", style = MaterialTheme.typography.headlineMedium)
            IconButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "edit name")
            }
        }
        StatisticsCard(
            questionAttempted = 10,
            correctAnswer = 7
        )
    }
}