package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dont_stop_app.HomeNavigation
import com.example.dont_stop_app.SettingsScreen
import com.example.myapplication.dont_stop_app.ItemDetailsScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.util.MySharedPref
import com.example.myapplication.view.AuthinticationScreens.Screens.LoginScreen
import com.example.myapplication.view.AuthinticationScreens.Screens.SignupScreen
import com.example.myapplication.view.onBording.OnboardingScreen
import com.example.myapplication.view.splashScreen.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check for token in SharedPreferences
        val sharedPref = MySharedPref(this)
        val token = sharedPref.getToken()
        val startDestination = if (token.isNullOrEmpty()) "splash_screen" else "home_screen"

        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController, startDestination = startDestination)
                }
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("login_screen") { LoginScreen(navController = navController) }
        composable("home_screen") { HomeNavigation(navController = navController) }
        composable("settings_screen") { SettingsScreen(navController = navController) }
        composable("signup_screen") { SignupScreen(navController = navController) }
        composable("product_detail_screen") { ItemDetailsScreen(navController = navController) }
        composable("splash_screen") {
            SplashScreen {
                navController.navigate("onboarding_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }
        }
        composable("onboarding_screen") {
            OnboardingScreen(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController, startDestination = "splash_screen")
    }
}

