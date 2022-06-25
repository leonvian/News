package com.lvc.lookingup.ui.listofnews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lvc.lookingup.model.News

@Composable
fun ListOfNewsScreen(
    newsList: List<News>
) {
    val state = rememberLazyListState()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start  = 16.dp, end = 16.dp),
         state = state
    ) {
        items(newsList,
            key = { it.url },
            //contentType = it.type Compose 1.2
        ) { news ->
            NewItem(news = news)
        }
    }
}

@Composable
fun NewItem(news: News) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(IntrinsicSize.Min)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = news.title,
                maxLines = 2,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = news.description,
                fontSize = 12.sp,
                maxLines = 4
            )
        }
    }
}