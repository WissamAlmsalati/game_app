package com.example.dont_stop_app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Spacer(modifier = Modifier.height(19.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(43.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .width(375.dp)
                .height(43.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(8.dp, shape = RoundedCornerShape(10.dp)),
                onClick = onClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White) // Set button color to white
            ) {
                Text(text = text, color = Color.Black) // Set text color to black
                Spacer(modifier = Modifier.width(200.dp))
                Icon(painter = painterResource(id = icon), contentDescription = null)
            }
        }
    }
}