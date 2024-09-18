package com.example.dont_stop_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AdCarousel() {
    val images = listOf(
        R.drawable.fifa,
        R.drawable.cod
    )
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true) {
            coroutineScope.launch {
                val nextIndex = (listState.firstVisibleItemIndex + 1) % images.size
                listState.animateScrollToItem(nextIndex)
            }
            delay(3000)
        }
    }

    LazyRow(
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(25.dp, alignment = Alignment.CenterHorizontally)
    ) {
        items(images) { image ->
            Box(
                modifier = Modifier
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Ad Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(6.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(30.dp))
                )
            }
        }
    }
}