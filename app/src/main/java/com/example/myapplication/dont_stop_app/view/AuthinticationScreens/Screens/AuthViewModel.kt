// File: app/src/main/java/com/example/myapplication/view/AuthinticationScreens/Screens/AuthViewModel.kt
package com.example.myapplication.view.AuthinticationScreens.Screens

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.User
import com.example.myapplication.network.loginUser
import com.example.myapplication.network.signupUser
import com.example.myapplication.util.MySharedPref
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    var isLoginSuccess by mutableStateOf(false)
    var isSignupSuccess by mutableStateOf(false)

    fun login(user: User, context: Context) {
        // Login logic
        viewModelScope.launch {
            val result = loginUser(user, context)
            isLoginSuccess = result.first

            // Example usage in your ViewModel
            val sharedPref = MySharedPref(context)
            sharedPref.saveToken(result.second ?: "")
            val retrievedToken = sharedPref.getToken()
            Log.d("MySharedPref", "Retrieved Token: $retrievedToken")
        }
    }

    fun signup(user: User) {
        // Signup logic
        viewModelScope.launch {
            val result = signupUser(user)
            isSignupSuccess = result.first
        }
    }

    // Other functions...
}