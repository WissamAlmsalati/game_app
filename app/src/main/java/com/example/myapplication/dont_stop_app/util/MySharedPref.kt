// File: app/src/main/java/com/example/myapplication/util/MySharedPref.kt
package com.example.myapplication.util

import android.content.Context
import android.util.Log

class MySharedPref(context: Context) {
    companion object {
        private const val FILE_KEY = "user_info"
        private const val TOKEN_KEY = "token_key"
    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPref.edit()
            .putString(TOKEN_KEY, token)
            .apply()
        Log.d("MySharedPref", "Token saved: $token")
    }

    fun getToken(): String? {
        val token = sharedPref.getString(TOKEN_KEY, null)
        Log.d("MySharedPref", "Token retrieved: $token")
        return token
    }
}