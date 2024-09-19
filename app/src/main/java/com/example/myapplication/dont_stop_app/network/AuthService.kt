package com.example.myapplication.network

import android.content.Context
import android.util.Log
import com.example.myapplication.util.MySharedPref
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class User(val UserName: String, val password: String, val email: String? = null)
data class AuthResponse(val token: String)

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        gson()
    }
}

suspend fun signupUser(user: User): Pair<Boolean, String?> {
    return withContext(Dispatchers.IO) {
        try {
            val response: HttpResponse = client.post("http://192.168.1.131:3000/users/signup") {
                contentType(ContentType.Application.Json)
                setBody(user)
            }
            val responseBody = response.bodyAsText()
            println(responseBody)
            Log.d("Login", "loginUser: $responseBody")

            if (response.status == HttpStatusCode.Created) {
                Pair(true, "User registered successfully")
            } else {
                Pair(false, responseBody)
            }
        } catch (e: Exception) {
            Log.d("Error" , "signupUser: " +e)
            Log.d("Error" , "signupUser: " +e.message)

            Pair(false, e.message)
        }
    }
}

suspend fun loginUser(user: User, context: Context): Pair<Boolean, String?> {
    return withContext(Dispatchers.IO) {
        try {
            val response: HttpResponse = client.post("http://192.168.1.131:3000/users/login") {
                contentType(ContentType.Application.Json)
                setBody(user)
            }
            val responseBody = response.bodyAsText()
            println(responseBody)
            Log.d("Login", "loginUser: " + responseBody)
            if (response.status == HttpStatusCode.OK) {
                val authResponse: AuthResponse = response.body()
                val sharedPref = MySharedPref(context)
                authResponse.token?.let {
                    sharedPref.saveToken(it)
                }
                Pair(true, authResponse.token)
            } else {
                Pair(false, responseBody)
            }
        } catch (e: Exception) {
            Log.d("Error", "signupUser: " + e)
            Log.d("Error", "signupUser: " + e.message)
            Pair(false, e.message)
        }
    }
}