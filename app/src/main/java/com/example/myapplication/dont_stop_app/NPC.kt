package com.example.myapplication.dont_stop_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dont_stop_app.ui.theme.MainColor
import com.example.dont_stop_app.ui.theme.WhiteColor
import com.example.myapplication.R
import compose.icons.SimpleIcons
import compose.icons.simpleicons.Nintendo
import compose.icons.simpleicons.Playstation
import compose.icons.simpleicons.Steam
import compose.icons.simpleicons.Xbox


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    // List of items in the cart
    val cartItems = remember { mutableStateListOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(0.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MainColor,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Cart",
                        maxLines = 1,
                        color = WhiteColor,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(onClick = { /* Handle image click */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.applogo),
                            contentDescription = "Action Image",
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cartItems.size) { index ->
                    card(cartItems[index], onDelete = {
                        cartItems.removeAt(index) // Remove item from the list
                    })
                }
            }

            Button(
                onClick = {
                    navController.navigate("order_info")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007AC3),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun card(itemName: String, onDelete: () -> Unit) {
    var itemCount by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .height(120.dp)
            .width(358.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .shadow(
                elevation = 150.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cod),
                    contentDescription = "image description",
                    modifier = Modifier
                        .height(75.dp)
                        .width(125.dp)
                        .clip(RoundedCornerShape(24.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = itemName, // Use item name passed as parameter
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Price: \$70",
                        modifier = Modifier.padding(bottom = 5.dp),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = onDelete) { // Trigger onDelete when delete is clicked
                        Icon(
                            imageVector = Icons.Default.DeleteOutline,
                            contentDescription = "Delete",
                            tint = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (itemCount > 1) itemCount-- }) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Decrement",
                                tint = Color.Black
                            )
                        }
                        Text(
                            text = itemCount.toString(), // Item count
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                        IconButton(onClick = { itemCount++ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Increment",
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailsScreen(modifier: Modifier = Modifier, navController: NavController) {
    var selectedPlatform by remember { mutableStateOf(-1) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Item Details") },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MainColor,
                    titleContentColor = WhiteColor
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack() // Navigate back to the previous screen
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = WhiteColor
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .padding(8.dp)
                    .padding(top = 20.dp, bottom = 25.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cod),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(226.dp)
                                .clip(RoundedCornerShape(36.dp))
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ScrollableRowOfImages()
                        Spacer(modifier = Modifier.height(16.dp))
                        GameInfo()
                        Spacer(modifier = Modifier.height(16.dp))
                        PlatformSelection()
                    }
                    addtocart()
                }
            }
        }
    )
}


@Composable
fun ScrollableRowOfImages() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        repeat(4) {
            Image(
                painter = painterResource(id = R.drawable.cod),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(155.dp)
                    .height(78.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GameInfo() {
    Column {
        Text(
            text = "Call of Duty",
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 26.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.W500,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Lorem Ipsum is simply dummy text...",
            modifier = Modifier
                .fillMaxWidth(),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 13.sp,
                lineHeight = 12.1.sp,
                fontWeight = FontWeight.W500,
                color = Color.Gray,
            )
        )
    }
}

@Composable
fun PlatformSelection() {
    val platforms = listOf("PlayStation", "Xbox", "Nintendo", "PC")
    var selectedPlatform by remember { mutableStateOf(platforms[0]) }
    Spacer(modifier = Modifier.height(18.dp))
    Column {
        Text(
            text = "Select Platform",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            platforms.forEach { platform ->
                PlatformButton(
                    platformName = platform,
                    isSelected = selectedPlatform == platform,
                    onClick = { selectedPlatform = platform }
                )
            }
        }
    }
}

@Composable
fun PlatformButton(platformName: String, isSelected: Boolean, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFF007AC3) else Color.White
        ),
        modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Icon(
            imageVector = when (platformName) {
                "PlayStation" -> SimpleIcons.Playstation
                "Xbox" -> SimpleIcons.Xbox
                "Nintendo" -> SimpleIcons.Nintendo
                "PC" -> SimpleIcons.Steam
                else -> Icons.Default.Add
            },
            contentDescription = platformName,
            tint = if (isSelected) Color.White else Color.Black
        )
    }
}

@Composable
fun addtocart() {
    var showDialog by remember { mutableStateOf(false) } // State to control dialog visibility

    Box(
        modifier = Modifier
            .shadow(4.dp)
            .height(83.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$70",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Button(
                onClick = {
                    showDialog = true // Show dialog when button is clicked
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007AC3),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Add to Cart")
            }
        }
    }

    // Show the dialog when showDialog is true
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false // Hide dialog when dismissed
            },
            confirmButton = {
                Button(onClick = {
                    showDialog = false // Hide dialog when clicked
                }) {
                    Text("OK")
                }
            },
            title = {
                Text(text = "Success")
            },
            text = {
                Text("Item added to cart successfully!")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderInfo(navController: NavController) {
    var selectedPaymentMethod by remember { mutableStateOf("Visa") }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Order Information") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MainColor,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFF2F2F2)) // Light background color for better contrast
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Subtotal",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "70$",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Shipping",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "Free",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Total",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "$70",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Delivery Address",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "More",
                                tint = Color.Black
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cod),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(75.dp)
                                    .width(125.dp)
                                    .clip(RoundedCornerShape(24.dp))
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Address",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            RadioButton(
                                selected = true,
                                onClick = { /* Handle radio button click */ }
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Payment Method",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.CreditCard,
                                contentDescription = "Payment Options",
                                tint = Color.Black
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cod),
                                contentDescription = "Visa",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(75.dp)
                                    .width(125.dp)
                                    .clip(RoundedCornerShape(24.dp))
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "Visa")
                            Spacer(modifier = Modifier.weight(1f))
                            RadioButton(
                                selected = selectedPaymentMethod == "Visa",
                                onClick = { selectedPaymentMethod = "Visa" }
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cod),
                                contentDescription = "Cash",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(75.dp)
                                    .width(125.dp)
                                    .clip(RoundedCornerShape(24.dp))
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(text = "Cash")
                            Spacer(modifier = Modifier.weight(1f))
                            RadioButton(
                                selected = selectedPaymentMethod == "Cash",
                                onClick = { selectedPaymentMethod = "Cash" }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Confirm Button at the bottom
                Button(
                    onClick = {
                        navController.navigate("home_screen") // Navigate to home
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF007AC3),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Confirm")
                }
            }
        }
    )
}
