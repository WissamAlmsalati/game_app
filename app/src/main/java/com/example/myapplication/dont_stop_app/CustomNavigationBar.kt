package com.example.dont_stop_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.dont_stop_app.ui.theme.MainColor
import com.example.dont_stop_app.ui.theme.WhiteColor
import com.example.myapplication.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CustomNavigationBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = MainColor,
        tonalElevation = 8.dp,

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedIndex == 0) WhiteColor else MainColor)
                    .clickable {
                        onItemSelected(0)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.home, // Replace with your SVG resource

                    ),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    colorFilter = if (selectedIndex == 0) ColorFilter.tint(MainColor) else ColorFilter.tint(
                        WhiteColor
                    )
                )
            }

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedIndex == 1) WhiteColor else MainColor)
                    .clickable {
                        onItemSelected(1)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.shop,
                        /*       builder = {
                                   crossfade(true)
                               }*/
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    colorFilter = if (selectedIndex == 1) ColorFilter.tint(MainColor) else ColorFilter.tint(
                        WhiteColor
                    )
                )
            }
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedIndex == 2) WhiteColor else MainColor)
                    .clickable {
                        onItemSelected(2)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.basket_alt_3, // Replace with your SVG resource
                        /*   builder = {
                               crossfade(true)
                           }*/
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    colorFilter = if (selectedIndex == 2) ColorFilter.tint(MainColor) else ColorFilter.tint(
                        WhiteColor
                    )
                )
            }
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedIndex == 3) WhiteColor else MainColor)
                    .clickable {
                        onItemSelected(3)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.setting_line, // Replace with your SVG resource
                        /* builder = {
                             crossfade(true)
                         }*/
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    colorFilter = if (selectedIndex == 3) ColorFilter.tint(MainColor) else ColorFilter.tint(
                        WhiteColor
                    )
                )
            }
        }

    }
}
