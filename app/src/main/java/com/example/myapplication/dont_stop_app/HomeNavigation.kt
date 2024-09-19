package com.example.dont_stop_app

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.dont_stop_app.Cart
import org.example.project.presentation.NavigationViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeNavigation(navController: NavController) {
    val viewModel: NavigationViewModel = viewModel()
    val selectedIndex by viewModel.selectedIndex.collectAsState()

    Scaffold(
        bottomBar = {
            CustomNavigationBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index -> viewModel.updateIndex(index) }
            )
        }
    ) { innerPadding ->
        AnimatedVisibility(
            visible = true,
            modifier = Modifier.fillMaxSize()
        ) {
            when (selectedIndex) {
                0 -> HomeScreen( navController = navController)
                1 -> ShopScreen( )
                2 -> Cart( navController = navController)
                3 -> SettingsScreen( navController = navController)
            }
        }
    }
}

