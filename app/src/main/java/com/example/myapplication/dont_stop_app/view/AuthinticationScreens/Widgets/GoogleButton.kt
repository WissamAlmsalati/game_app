package com.example.myapplication.view.AuthinticationScreens.Widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun GoogleSignInButton(
    buttonText: String,
    backgroundColor: Color,
    contentColor: Color,
    onClickAction: () -> Unit
) {
    Button(
        onClick = { onClickAction() },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor, // Background color of the button
            contentColor = contentColor // Text color
        ),
        shape = RoundedCornerShape(16.dp), // Rounded corners
        modifier = Modifier
            .width(375.dp)
            .height(60.dp)
            .padding(vertical = 8.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp) // Add elevation to the button
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Google Logo (Assuming you have the Google logo image in your resources)
            Image(
                painter = painterResource(id = R.drawable.applogo), // Replace with your Google logo resource
                contentDescription = "Google Logo",
                modifier = Modifier
                    .size(24.dp)
                    .padding(top = 6.dp,end = 8.dp),
                contentScale = ContentScale.Fit
            )
            // Button Text
            Text(
                text = buttonText,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}