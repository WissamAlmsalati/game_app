package com.example.myapplication.view.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dont_stop_app.ui.theme.MainColor
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.view.HomeScreen.widgets.CustomTextField
import com.example.myapplication.view.components.AppBar

@Composable
fun HomeScreen() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Surface(color = MaterialTheme.colorScheme.background) {
        Scaffold(
            topBar = { AppBar(title = "UserName") }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.padding(14.dp))
                CustomTextField(
                    text = textState.value,
                    onValueChange = { textState.value = it },
                    hint = "Email",
                    containerColor = Color.White,
                    focusedIndecatorColor = MainColor,
                    unfocusedColor = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    focusColor = Color(0xFF6200EE)
                )

//                OutlinedTextField("",{})
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}