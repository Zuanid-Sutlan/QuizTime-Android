package com.example.quiztime_android.presentation.components.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.quiztime_android.R

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun TopicCard(
    modifier: Modifier = Modifier,
    topicName: String = "Android",
    imageUrl: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAq_P6bFIFwZjrDzPNwbHvz4dRRmq8ihzADg&s",
    onClick: ()-> Unit = {}
) {
    Box {
        Card(modifier = modifier.clickable{ onClick() }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), verticalArrangement = Arrangement.Bottom
            ) {
                Icon(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .size(20.dp),
                    painter = painterResource(R.drawable.ic_smart_display),
                    contentDescription = "icon smart display",
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = topicName,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        TopicImage(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 10.dp)
                .size(100.dp)
                .offset(y = (-20).dp),
            imageUrl = imageUrl
        )
    }
}

@Composable
private fun TopicImage(modifier: Modifier = Modifier, imageUrl: String) {

    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .data(imageUrl)
        .crossfade(enable = true)
        .build()

    AsyncImage(
        modifier = modifier,
        model = imageRequest,
        placeholder = painterResource(R.drawable.general),
        error = painterResource(R.drawable.general),
        contentDescription = "topic image",
        alignment = Alignment.TopCenter
    )
}