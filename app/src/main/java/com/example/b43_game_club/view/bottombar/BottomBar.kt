package com.example.b43_game_club.view.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue

@Composable
fun BottomBar(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    val screens = listOf(DestinationsBB.HomeScreen, DestinationsBB.CreateOrderScreen, DestinationsBB.ProfileScreen)
    Box(modifier = Modifier) {
        NavigationBar(
            modifier = modifier,
            containerColor = B43Theme.colors.primaryContainer,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->
                if(screen.route != "create_order") {
                    Column(modifier = Modifier
                        .weight(1f).padding(vertical = 10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        var selectedColor = Brush.horizontalGradient(
                            listOf(B43Theme.colors.onBackground, B43Theme.colors.onBackground))
                        if(currentRoute == screen.route) {
                            selectedColor = gradientButtonPinkBlue
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Icon(imageVector = ImageVector.vectorResource(id = screen.resourceId!!),
                            modifier = Modifier.size(30.dp)
                                .drawWithCache {
                                    onDrawWithContent {
                                        drawContent()
                                        drawRect(selectedColor, blendMode = BlendMode.Darken)
                                    }
                                },
                            contentDescription = "")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = screen.title!!, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, style = TextStyle(
                            brush = selectedColor
                        ))
                    }
                } else {
                    Icon(imageVector = ImageVector.vectorResource(id = screens[1].resourceId!!), tint = Color.Unspecified,
                        modifier = Modifier
                            .size(45.dp)
                            .background(B43Theme.colors.primary, RoundedCornerShape(10.dp)).padding(10.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null) {
                                navController.navigate(screens[1].route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },contentDescription = "")
                }
            }
        }


    }

}