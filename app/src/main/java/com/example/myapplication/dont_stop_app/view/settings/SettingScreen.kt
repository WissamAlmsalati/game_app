package com.example.myapplication.view.settings


import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier

            .fillMaxSize()
            .background(Color(0xFFF5F5F5)), // Enable vertical scrolling
    ) {
        // Top Section
        Box(
            modifier = Modifier

                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF007AC3)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id=R.drawable.applogo), // Replace with your logo
                        contentDescription = "Logo",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        text = "Don't Stop",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
                IconButton(onClick = { /* Do something */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.applogo), // Replace with your icon
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(43.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .width(328.dp)
                    .height(43.dp)
            ) {
                var isDarkMode by remember { mutableStateOf(false) }

                Button(
                    modifier = Modifier
                        .fillMaxSize()
                        .width(350.dp)
                        .background(Color(0xFFFFFFFF))
                        .shadow(8.dp, shape = RoundedCornerShape(10.dp)),
                    onClick = { Unit },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(text = "Dark mode", color = Color.Black)
                    Spacer(modifier = Modifier.width(200.dp)) // Add space between text and switch
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = { isDarkMode = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFF007AC3), // Thumb color when switch is on
                            checkedTrackColor = Color(0xFFB0D6EC)  // Track color when switch is on
                        )
                    )
                }
            }
        }





        CustomButton(text = "Change password", icon = R.drawable.applogo)
        CustomButton(text = "Change User name", icon = R.drawable.applogo)
        CustomButton(text = "Log out", icon = R.drawable.applogo)
    }
}






@Composable
fun CustomButton(text: String, icon: Int) {
    Spacer(modifier = Modifier.height(19.dp))
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(43.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .width(328.dp)
                .height(43.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(8.dp, shape = RoundedCornerShape(10.dp)),
                onClick = { Unit },
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



//
//@Composable
//fun BottomNavigation(backgroundColor: Color, content: () -> Unit) {
//
//}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}


