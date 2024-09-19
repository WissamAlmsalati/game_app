package com.example.myapplication.view.AuthinticationScreens.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.network.User
import com.example.myapplication.view.AuthinticationScreens.Widgets.CustomButton
import com.example.myapplication.view.AuthinticationScreens.Widgets.CustomLogField
import com.example.myapplication.view.AuthinticationScreens.Widgets.CustomTextButton
import kotlinx.coroutines.launch

@Composable
fun SignupScreen(navController: NavController) {
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val viewModel: AuthViewModel = viewModel()
    LaunchedEffect(viewModel.isSignupSuccess) {

        if (viewModel.isSignupSuccess) {
            Log.d("", "SignupScreen: Sighup success")
            navController.navigate("login_screen")
        } else {
                snackbarHostState.showSnackbar(
                    message = "Signup failed",
                    duration = SnackbarDuration.Short
                )

        }
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Surface(
            color = Color(0xFF007AC3),
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(
                containerColor = Color.Transparent,
                snackbarHost = { SnackbarHost(snackbarHostState) }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    val image: Painter = painterResource(id = R.drawable.applogo)
                    Image(
                        painter = image,
                        contentDescription = "Logo",
                        modifier = Modifier
                            .height(220.dp)
                            .width(220.dp)
                            .padding(10.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomLogField(
                        labelText = "Username",
                        text = username.value,
                        onValueChange = { username.value = it },
                        hint = "Enter your Username",
                        containerColor = Color.White,
                        focusedIndecatorColor = Color(0xFFffffff),
                        unfocusedColor = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        focusColor = Color(0xFF007AC3),
                        placeholderTextStyle = TextStyle(fontSize = 8.sp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    CustomLogField(
                        labelText = "Email",
                        text = email.value,
                        onValueChange = { email.value = it },
                        hint = "Enter your Email",
                        containerColor = Color.White,
                        focusedIndecatorColor = Color(0xFFffffff),
                        unfocusedColor = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        focusColor = Color(0xFF007AC3),
                        placeholderTextStyle = TextStyle(fontSize = 8.sp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    CustomLogField(
                        labelText = "Password",
                        text = password.value,
                        onValueChange = { password.value = it },
                        hint = "Enter your Password",
                        containerColor = Color.White,
                        focusedIndecatorColor = Color(0xFFffffff),
                        unfocusedColor = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        focusColor = Color(0xFF007AC3),
                        placeholderTextStyle = TextStyle(fontSize = 8.sp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomButton(
                        buttonText = "Sign up",
                        backgroundColor = Color(0xFFffffff),
                        contentColor = Color.Black,
                        onClickAction = {
                            val user = User(
                                UserName = username.value.text,
                                password = password.value.text,
                                email = email.value.text
                            )

                                viewModel.signup(user)


                        }
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CustomTextButton(
                            text = "I have an account",
                            onClick = { navController.navigate("login_screen") },
                            modifier = Modifier.padding(top = 5.dp, start = 2.dp, bottom = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(navController = rememberNavController())
}