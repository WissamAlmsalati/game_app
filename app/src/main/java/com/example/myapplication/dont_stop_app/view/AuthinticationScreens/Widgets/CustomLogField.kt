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
    containerColor: Color,
    focusedIndecatorColor: Color,
    unfocusedColor: Color,
    shape: RoundedCornerShape,
    focusColor: Color, // New parameter for focus color
    placeholderTextStyle: TextStyle = TextStyle(fontSize = 16.sp), // New parameter for placeholder text style
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
                fontSize = 8.sp,
                color = Color.White // Same blue color as the one in the image
            )
        )
        Card(
            shape = shape,
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp), // Use CardDefaults.cardElevation
            modifier = Modifier
                .width(375.dp)
                .height(60.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = onValueChange,
                placeholder = { Text(hint, style = placeholderTextStyle , ) },
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
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}