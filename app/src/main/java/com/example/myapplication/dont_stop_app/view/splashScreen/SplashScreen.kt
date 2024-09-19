package com.example.myapplication.view.splashScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R


@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val scale = remember { Animatable(1f) }
    val logoAlpha = remember { Animatable(1f) }

    LaunchedEffect(key1 = true) {
        logoAlpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 3000)
        )
//        scale.animateTo(
//            targetValue = 1.5f,
//            animationSpec = tween(durationMillis = 1000)
//        )
//        delay(200L)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF007AC3)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.applogo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .alpha(logoAlpha.value),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen {
        // Preview does not navigate
    }
}