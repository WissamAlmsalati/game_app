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
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.dont_stop_app.Cart
import org.example.project.presentation.NavigationViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeNavigation() {
    val viewModel: NavigationViewModel = viewModel()
    val selectedIndex by viewModel.selectedIndex.collectAsState()
    val navController = rememberNavController()

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
                0 -> HomeScreen()
                1 -> ShopScreen()
                2 -> Cart()
                3 -> SettingsScreen()
            }
        }
    }
}

