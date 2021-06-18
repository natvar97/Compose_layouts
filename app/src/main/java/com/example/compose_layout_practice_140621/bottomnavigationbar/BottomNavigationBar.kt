package com.example.compose_layout_practice_140621.bottomnavigationbar

import androidx.compose.foundation.clickable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navDeepLink
import com.google.accompanist.glide.rememberGlidePainter
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class BottomNavigationBar {

    @Composable
    fun BottomNavBar(
        modifier: Modifier = Modifier,
        screens: List<Screens.HomeScreen>,
        navController: NavController
    ) {

        BottomNavigation(
            modifier = modifier
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val KEY_ROUTE = "Mails"
            val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

            screens.forEach { screen ->
                BottomNavigationItem(
                    selected = currentRoute == screen.route,
                    icon = { Icon(painter = rememberGlidePainter(request = screen.icon), contentDescription = "")},
                    label = { Text(text = screen.title)},
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    }
                )
            }
        }

    }

}