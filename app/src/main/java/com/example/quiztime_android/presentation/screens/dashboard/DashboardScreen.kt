package com.example.quiztime_android.presentation.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.domain.model.QuizTopic
import com.example.quiztime_android.presentation.components.dashboard.StatisticsCard
import com.example.quiztime_android.presentation.components.dashboard.TopicCard

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen(modifier: Modifier = Modifier, state: DashboardState = DashboardState()) {
    Column {
        Spacer(Modifier.height(30.dp))
        HeaderSection(
            username = state.userName,
            questionAttempted = state.questionAttempted,
            correctAnswer = state.correctAnswers
        )
        QuizSection(
            topicList = state.quizTopic
        )
    }
}

@Composable
private fun HeaderSection(modifier: Modifier = Modifier, username: String, questionAttempted: Int, correctAnswer: Int) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Hello", style = MaterialTheme.typography.bodyMedium)
        Row {
            Text(text = username, style = MaterialTheme.typography.headlineMedium)
            IconButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "edit name")
            }
        }
        StatisticsCard(
            questionAttempted = questionAttempted,
            correctAnswer = correctAnswer
        )
    }
}

@Composable
private fun QuizSection(modifier: Modifier = Modifier, topicList: List<QuizTopic>) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "What Topic you want to improve today?",
            style = MaterialTheme.typography.titleLarge
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(topicList) { topic ->
                TopicCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    topicName = topic.name,
                    imageUrl = topic.imageUrl,
                    onClick = {}
                )
            }
        }
    }
}