package com.example.myapplication.view.HomeScreen.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    hint: String,
    containerColor: Color,
    focusedIndecatorColor: Color,
    unfocusedColor: Color,
    shape: RoundedCornerShape,
    focusColor: Color, // New parameter for focus color
    placeholderTextStyle: TextStyle = TextStyle(fontSize = 16.sp), // New parameter for placeholder text style
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            placeholder = { Text(hint, style = placeholderTextStyle) }, // Apply the placeholder text style
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = containerColor,
                focusedBorderColor = focusedIndecatorColor,
                unfocusedBorderColor = unfocusedColor,
                cursorColor = focusColor, // Use the new focus color parameter
                focusedLabelColor = focusColor, // Add focused label color
                unfocusedLabelColor = unfocusedColor // Add unfocused label color
            ),
            shape = shape,
            textStyle = TextStyle(fontSize = 16.sp), // Set font size here
            modifier = Modifier
                .width(375.dp)
                .height(60.dp),
            maxLines = 1
        )
    }
}