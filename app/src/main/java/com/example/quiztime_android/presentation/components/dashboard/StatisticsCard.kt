package com.example.quiztime_android.presentation.components.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.R
import com.example.quiztime_android.presentation.theme.customBlue
import com.example.quiztime_android.presentation.theme.customPink

@Preview(showBackground = false)
@Composable
fun StatisticsCard(
    modifier: Modifier = Modifier,
    questionAttempted: Int = 10,
    correctAnswer: Int = 4
) {

    val progress = if (questionAttempted > 0) {
        correctAnswer.toFloat() / questionAttempted.toFloat()
    } else {
        0f
    }

    Card(modifier = modifier) {
        ProgressBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(15.dp),
            progress = progress
        )

        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Statistics(modifier = Modifier.weight(1f), value = questionAttempted, description = "Question Attempted")
            Statistics(modifier = Modifier.weight(1f), value = correctAnswer, description = "Correct Answer")
        }
    }
}

@Composable
private fun Statistics(
    modifier: Modifier = Modifier,
    value: Int = 23,
    description: String = "",
    iconResId: Int = R.drawable.ic_touch
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(modifier = Modifier.size(30.dp), painter = painterResource(id = iconResId), contentDescription = null)
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column() {
            Text(
                text = "$value",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Text(text = description, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
private fun ProgressBar(
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(customPink, customBlue),
    progress: Float = 0.7f
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.extraSmall)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(progress)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(Brush.linearGradient(gradientColors))
        )
        Box(
            modifier = Modifier
                .padding(end = 5.dp)
                .clip(CircleShape)
                .size(5.dp)
                .align(Alignment.CenterEnd)
                .background(Brush.linearGradient(gradientColors))
        )
    }
}