package org.example.project.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LaptopChromebook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.dont_stop_app.ui.theme.MainColor
import com.example.dont_stop_app.ui.theme.WhiteColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationViewModel : ViewModel() {
    private val _selectedIndex = MutableStateFlow(0)
    val selectedIndex: StateFlow<Int> = _selectedIndex

    fun updateIndex(index: Int) {
        _selectedIndex.value = index
    }
}
//
//
//
//
//
//
//
//@Composable
//fun CartScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 80.dp, bottom = 80.dp),
//        //  .background(Color.Green),
//        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        LazyColumn(
//            modifier = Modifier
//                .weight(1f)
//                .padding(bottom = 20.dp),
//            //   .background(Color.Red),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            items(5) {
//                card()
//            }
//        }
//        Button(
//            onClick = {  },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .height(50.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color(0xFF007AC3),
//                contentColor = Color.White
//            )
//        ) {
//            Text(text = "Continue")
//        }
//    }
//}
//
//@Composable
//fun card() {
//    Box(
//        modifier = Modifier
//            .padding(16.dp)
//            .height(120.dp) // Adjusted height to fit the button
//            .width(358.dp)
//            .background(Color.Gray, shape = RoundedCornerShape(16.dp))
//            .clip(RoundedCornerShape(16.dp))
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.cod),
//                    contentDescription = "image description",
//                    modifier = Modifier
//                        .height(75.dp)
//                        .width(125.dp)
//                        .clip(RoundedCornerShape(24.dp))
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Column(
//                    modifier = Modifier.weight(1f)
//                ) {
//                    Text(
//                        text = "Item Name",
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.Black
//                        )
//                    )
//                    Spacer(modifier = Modifier.height(4.dp))
//                    Text(
//                        text = "Price: \$70",
//                        style = androidx.compose.ui.text.TextStyle(
//                            fontSize = 18.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.Black
//                        )
//                    )
//                }
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    IconButton(onClick = { /* Handle delete action */ }) {
//                        Icon(
//                            imageVector = Icons.Default.Delete,
//                            contentDescription = "Delete",
//                            tint = Color.Black
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        IconButton(onClick = { /* Handle decrement action */ }) {
//                            Icon(
//                                imageVector = Icons.Default.Remove,
//                                contentDescription = "Decrement",
//                                tint = Color.Black
//                            )
//                        }
//                        Text(
//                            text = "1", // Item count
//                            style = androidx.compose.ui.text.TextStyle(
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = Color.Black
//                            )
//                        )
//                        IconButton(onClick = { /* Handle increment action */ }) {
//                            Icon(
//                                imageVector = Icons.Default.Add,
//                                contentDescription = "Increment",
//                                tint = Color.Black
//                            )
//                        }
//                    }
//                }
//            }
//
//        }
//
//    }
//}
//
//@Composable
//fun Header(modifier: Modifier = Modifier) {
//    var selectedPlatform by remember { mutableStateOf(-1) }
//
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .padding(top = 80.dp, bottom = 25.dp)
//    ) {
//        Column(
//            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.fillMaxHeight()
//        ) {
//            Column {
//                Image(
//                    painter = painterResource(id = R.drawable.cod),
//                    contentDescription = "image description",
//                    contentScale = ContentScale.FillBounds,
//                    modifier = Modifier
//                        .height(226.dp)
//                        .clip(RoundedCornerShape(36.dp))
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                ScrollableRowOfImages()
//                Spacer(modifier = Modifier.height(16.dp))
//                GameInfo()
//                Spacer(modifier = Modifier.height(16.dp))
//                PlatformSelection()
//            }
//            addtocart()
//        }
//    }
//}
//
//@Composable
//fun ScrollableRowOfImages() {
//    Row(
//        modifier = Modifier
//            .horizontalScroll(rememberScrollState())
//    ) {
//        repeat(3) {
//            Image(
//                painter = painterResource(id = R.drawable.cod),
//                contentDescription = "image description",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .width(155.dp)
//                    .height(78.dp)
//                    .clip(RoundedCornerShape(16.dp))
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//        }
//    }
//}
//
//@Composable
//fun GameInfo() {
//    Column {
//        Text(
//            text = "Call of Duty",
//            modifier = Modifier
//                .width(110.dp)
//                .height(28.dp),
//            style = androidx.compose.ui.text.TextStyle(
//                fontSize = 20.sp,
//                lineHeight = 28.sp,
//                fontWeight = FontWeight.W500,
//                color = Color.Black,
//            )
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = "Lorem Ipsum is simply dummy text...",
//            modifier = Modifier.width(309.dp),
//            style = androidx.compose.ui.text.TextStyle(
//                fontSize = 11.sp,
//                lineHeight = 12.1.sp,
//                fontWeight = FontWeight.W500,
//                color = Color.Black,
//            )
//        )
//    }
//}
//
//@Composable
//fun PlatformSelection() {
//    val platforms = listOf("PlayStation", "Xbox", "Nintendo", "PC")
//    var selectedPlatform by remember { mutableStateOf(platforms[0]) }
//
//    Column {
//        Spacer(modifier = Modifier.height(12.dp))
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            modifier = Modifier.horizontalScroll(rememberScrollState())
//        ) {
//            platforms.forEach { platform ->
//                PlatformButton(
//                    platformName = platform,
//                    isSelected = selectedPlatform == platform,
//                    onClick = { selectedPlatform = platform }
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun PlatformButton(platformName: String, isSelected: Boolean, onClick: () -> Unit) {
//    Button(
//        onClick = onClick,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = if (isSelected) Color(0xFF007AC3) else Color.White
//        ),
//        modifier = Modifier
//            .size(64.dp)
//            .clip(RoundedCornerShape(8.dp))
//    ) {
//        Icon(
//            imageVector = when (platformName) {
//                "PlayStation" -> Icons.Default.Add
//                "Xbox" -> Icons.Default.Remove
//                "Nintendo" -> Icons.Default.DeleteOutline
//                "PC" -> Icons.Default.LaptopChromebook
//                else -> Icons.Default.Add
//            },
//            contentDescription = platformName,
//            tint = if (isSelected) Color.White else Color.Black
//        )
//    }
//}
//
//@Composable
//fun addtocart() {
//    Box(
//        modifier = Modifier
//            .shadow(4.dp)
//            .height(83.dp)
//            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
//            .padding(16.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "$70",
//                style = androidx.compose.ui.text.TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Button(
//                onClick = { /* Handle Add to Cart click */ },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xFF007AC3),
//                    contentColor = Color.White
//                )
//            ) {
//                Text(text = "Add to Cart")
//            }
//        }
//    }
//}
//
//@Composable
//fun ItemDetails() {
//    var selectedPaymentMethod by remember { mutableStateOf("Visa") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(816.dp)
//            .padding(top = 56.dp)
//        // .background(Color.Gray)
//    ) {
//        // Order Information Header
//        Text(
//            text = "Order Information",
//            style = TextStyle(
//                fontSize = 35.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black
//            ),
//            modifier = Modifier
//                .padding(top = 16.dp)
//                .padding(horizontal = 16.dp)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Subtotal Row
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Subtotal",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = "$70",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Shipping Row
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Shipping",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = "Free",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        // Total Row
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Total",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Text(
//                text = "$70",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        // Delivery Address Row
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Delivery Address",
//                style = TextStyle(
//                    fontSize = 26.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Icon(
//                imageVector = Icons.Default.ArrowForward,
//                contentDescription = "More",
//                tint = Color.Black
//            )
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.cod),
//                contentDescription = "image description",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .height(75.dp)
//                    .width(125.dp)
//                    .clip(RoundedCornerShape(24.dp))
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Text(
//                text = "Address",
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            RadioButton(
//                selected = true,
//                onClick = { /* Handle radio button click */ }
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        // Payment Method Row
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Payment Method",
//                style = TextStyle(
//                    fontSize = 26.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//            )
//            Spacer(modifier = Modifier.weight(1f))
//            Icon(
//                imageVector = Icons.Default.AutoAwesomeMosaic,
//                contentDescription = "More",
//                tint = Color.Black,
//                modifier = Modifier.padding(end = 0.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        // Payment Options (Visa)
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.cod),
//                contentDescription = "Visa",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .height(75.dp)
//                    .width(125.dp)
//                    .clip(RoundedCornerShape(24.dp))
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Text(text = "Visa")
//            Spacer(modifier = Modifier.weight(1f))
//            RadioButton(
//                selected = selectedPaymentMethod == "Visa",
//                onClick = { selectedPaymentMethod = "Visa" }
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        // Payment Options (Cash)
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.cod),
//                contentDescription = "Cash",
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .height(75.dp)
//                    .width(125.dp)
//                    .clip(RoundedCornerShape(24.dp))
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Text(text = "Cash")
//            Spacer(modifier = Modifier.weight(1f))
//            RadioButton(
//                selected = selectedPaymentMethod == "Cash",
//                onClick = { selectedPaymentMethod = "Cash" }
//            )
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Confirm Button
//        Button(
//            onClick = { /* Handle continue action */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .height(50.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color(0xFF007AC3),
//                contentColor = Color.White
//            )
//        ) {
//            Text(text = "Confirm")
//        }
//    }
//}
//
//
//
//
//
////
////@Composable
////fun BottomNavigation(backgroundColor: Color, content: () -> Unit) {
////
////}
//
////@Preview(showBackground = true)
////@Composable
////fun SettingsScreenPreview() {
////    SettingsScreen()
////}
////
