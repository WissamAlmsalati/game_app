package com.example.myapplication.view.onBording

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R.*

@Composable
fun OnboardingScreen(navController: NavController) {
    var currentStep by remember { mutableIntStateOf(0) }

    val titles = listOf(
        "Don't Stop for gaming",
        "All Gamers want in one place",
        "Welcome to our world"
    )

    val buttonTexts = listOf("Next", "Next", "Start")
    val imageResources = listOf(
        drawable.code,
        drawable.full_shot_ninja_wearing_equipment,
        drawable.view_3d_video_game_controller
    )
    Spacer(modifier = Modifier.height((-10).dp))
    Box(
        modifier = Modifier
            .fillMaxSize(),
//
    ) {
        Image(
            painter = painterResource(id = imageResources[currentStep]), // Image changes with current step
            contentDescription = null,
            modifier = Modifier
                .background(color = Color(0xFFFFFFFF)) // Background color
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(Color(0xFF007AC3))
                .height(256.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//
            Text(
                text = titles[currentStep],
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .height(75.dp)
            )

            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .size(15.dp)
                            .background(
                                if (index == currentStep) Color.White else Color(0xFFB0D6EC),
                                shape = CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Button(
                onClick = {
                    if (currentStep < 2) {
                        currentStep++
                    } else {

                        navController.navigate("login_screen")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 30.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = buttonTexts[currentStep],
                    fontSize = 20.sp,
                    color = Color(0xFF007AFF)
                )
            }
        }
    }
}

//@Composable
//fun OnboardingScreen1(navController: NavController) {
//
//    Button(onClick = { navController.navigate("onboarding2") }) {
//        Text("Next")
//    }
//}
//
//@Composable
//fun OnboardingScreen2(navController: NavController) {
//
//    Button(onClick = { navController.navigate("onboarding3") }) {
//        Text("Next")
//    }
//}

//@Composable
//fun OnboardingScreen3(navController: NavController) {
//
//    Button(onClick = { navController.navigate("next_screen") }) {
//        Text("Start")
//    }
//}

//@Composable
//fun OnboardingNavGraph(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "onboarding1") {
//        composable("onboarding1") { OnboardingScreen1(navController) }
//        composable("onboarding2") { OnboardingScreen2(navController) }
//        composable("onboarding3") { OnboardingScreen3(navController) }
//        composable("next_screen") { NextScreen() }
//    }
//}

//@Composable
//fun NextScreen() {
//    Text(
//    text = "Welcome to the next screen!",
//    modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize(Alignment.Center)
//)
//
//}

@Preview(showBackground = true)
@Composable
private fun GetPreview() {

    val navController = rememberNavController()


    OnboardingScreen(navController = navController)
}