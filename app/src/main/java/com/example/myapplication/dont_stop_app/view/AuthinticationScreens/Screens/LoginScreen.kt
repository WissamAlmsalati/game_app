package com.example.myapplication.view.AuthinticationScreens.Screens

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.network.User
import com.example.myapplication.network.loginUser
import com.example.myapplication.view.AuthinticationScreens.Widgets.CustomButton
import com.example.myapplication.view.AuthinticationScreens.Widgets.CustomLogField
import com.example.myapplication.view.AuthinticationScreens.Widgets.CustomTextButton
import com.example.myapplication.view.AuthinticationScreens.Widgets.GoogleSignInButton
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
   val email = remember { mutableStateOf(TextFieldValue("")) }
   val password = remember { mutableStateOf(TextFieldValue("")) }
   val snackbarHostState = remember { SnackbarHostState() }
   val coroutineScope = rememberCoroutineScope()
   val viewModel: AuthViewModel = viewModel()
   val context = LocalContext.current

   LaunchedEffect(viewModel.isLoginSuccess) {
      if (viewModel.isLoginSuccess) {
         navController.navigate("signup_screen")
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
                  buttonText = "Log in",
                  backgroundColor = Color(0xFFffffff),
                  contentColor = Color.Black
               ) {
                  val user = User(
                     UserName = email.value.text,
                     email = email.value.text,
                     password = password.value.text
                  )
                  viewModel.login(user, context)
                  coroutineScope.launch {
                     val (success, message) = loginUser(user, context)
                     snackbarHostState.showSnackbar(
                        message = message ?: "Unknown error",
                        duration = SnackbarDuration.Short
                     )
                  }
               }
               Spacer(modifier = Modifier.height(5.dp))
               Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.Center
               ) {
                  Text(
                     text = "Don't have an account?",
                     style = TextStyle(color = Color.White, fontSize = 10.sp),
                        modifier = Modifier.padding(top = 13.dp, end = 2.dp, bottom = 2.dp)
                  )
                  CustomTextButton(
                     text = "Create one",

                     onClick = { navController.navigate("signup_screen") },
                     modifier = Modifier.padding(top = 8.dp, start = 2.dp, bottom = 2.dp)
                  )
               }
                  Spacer(modifier = Modifier.height(20.dp))
                  Row(
                     verticalAlignment = Alignment.CenterVertically,
                     modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                  ) {
                     HorizontalDivider(modifier = Modifier.weight(1f))

                     Text(
                        text = "or",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = TextStyle(color = Color.White, fontSize = 10.sp )
                     )
                     HorizontalDivider(modifier = Modifier.weight(1f)
                     )
               }
               Spacer( modifier = Modifier.height(20.dp))
               GoogleSignInButton(
                  buttonText = "Sign in with Google",
                  backgroundColor = Color(0xFFffffff),
                  contentColor = Color.Black
               ) {
                  // Handle Google Sign in

            }
               GoogleSignInButton(
                  buttonText = "Sign in with Google",
                  backgroundColor = Color(0xFFffffff),
                  contentColor = Color.Black
               ) {
                  navController.navigate("home_screen")

               }
         }
      }
   }
}}