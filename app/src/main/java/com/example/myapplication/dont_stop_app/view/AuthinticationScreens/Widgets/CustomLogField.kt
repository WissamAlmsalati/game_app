package com.example.myapplication.view.AuthinticationScreens.Widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomLogField(
    labelText: String,
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    hint: String,
    containerColor: Color = Color.Gray, // Default container color to grey
    focusedIndecatorColor: Color = Color.Blue, // Default focused indicator color to blue
    unfocusedColor: Color = Color.Transparent, // No border when unfocused
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    focusColor: Color = Color.Blue, // Default focus color to blue
    placeholderTextStyle: TextStyle = TextStyle(fontSize = 16.sp),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = labelText,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 3.dp, bottom = 10.dp),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.White
            )
        )
        Card(
            shape = shape,
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            modifier = Modifier
                .width(350.dp)
                .height(60.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = onValueChange,
                placeholder = { Text(hint, style = placeholderTextStyle) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = containerColor,
                    focusedBorderColor = focusedIndecatorColor,
                    unfocusedBorderColor = unfocusedColor,
                    cursorColor = focusColor,
                    focusedLabelColor = focusColor,
                    unfocusedLabelColor = unfocusedColor,
                ),
                shape = shape,
                textStyle = TextStyle(fontSize = 16.sp),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}