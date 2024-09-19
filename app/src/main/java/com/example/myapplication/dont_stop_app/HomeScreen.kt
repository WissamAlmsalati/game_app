package com.example.dont_stop_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dont_stop_app.ui.theme.MainColor
import com.example.dont_stop_app.ui.theme.WhiteColor
import com.example.myapplication.R

data class Product(
    val imageRes: Int,
    val name: String,
    val detail: String,
    val price: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val products = listOf(
        Product(R.drawable.cod, "Call Of Duty", "Product Detail", "70$"),
        Product(R.drawable.fifa, "FC24", "Product Detail", "50$"),
        Product(R.drawable.ghost_of_tsushima, "GHOST", "Product Detail", "40$"),
        Product(R.drawable.god_of_war_ragnarok_featured_image, "God of War", "Product Detail", "50$"),
        Product(R.drawable.thumb_1920_1168382_1024x576, "FORZA HORIZON", "Product Detail", "59.99$"),
        Product(R.drawable._1nv13knp_l, "Nintendo Controller", "Product Detail", "30$")
    )

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(0.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(MainColor, Color(0xFF007AC3))
                        )
                    ),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = WhiteColor,
                ),
                title = {
                    Text(
                        "Don't Stop",
                        maxLines = 1,
                        color = WhiteColor,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { /* Handle image click */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.applogo),
                            contentDescription = "Action Image",
                            modifier = Modifier

                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column {
                SearchTextField()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(11.dp)
                ) {
                    item(span = { GridItemSpan(2) }) {
                        AdCarousel()
                    }
                    item(span = { GridItemSpan(2) }) {
                        Text(
                            "Featured Products",
                            color = MainColor,
                            fontSize = 20.sp
                        )
                    }
                    items(products.size) { index ->
                        val product = products[index]
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
                                .clickable {
                                    // Navigate to product detail screen
                                    navController.navigate("product_detail_screen")
                                }
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .width(360.dp)
                                    .height(914.dp)
                                    .background(color = Color(0xF0FEFEFE))
                            ) {
                                Image(
                                    painter = painterResource(id = product.imageRes),
                                    contentDescription = "Product Image",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(350.dp)
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(16.dp))
                                )
                                Text(
                                    product.name,
                                    color = MainColor,
                                    fontSize = 12.sp
                                )
                                Text(
                                    product.detail,
                                    color = MainColor,
                                    fontSize = 10.sp
                                )
                                Text(
                                    product.price,
                                    color = MainColor,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
}