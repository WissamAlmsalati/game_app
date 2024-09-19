// File: app/src/main/java/com/example/myapplication/dont_stop_app/SettingScreen.kt
package com.example.dont_stop_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.util.MySharedPref

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController?) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "Settings",
                                color = Color.White,
                            )
                        }
                        IconButton(onClick = { /* Do something */ }) {
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF007AC3)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding) // Apply inner padding from Scaffold
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(43.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .width(378.dp)
                        .height(50.dp)
                ) {
                    var isDarkMode by remember { mutableStateOf(false) }

                    Button(
                        modifier = Modifier
                            .fillMaxSize()
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
            CustomButton(text = "Log out", icon = R.drawable.applogo, onClick = {
                val sharedPref = MySharedPref(context)
                sharedPref.clearToken()
                navController?.navigate("login_screen") {
                    popUpTo("home_screen") { inclusive = true }
                }
            })
        }
    }
}