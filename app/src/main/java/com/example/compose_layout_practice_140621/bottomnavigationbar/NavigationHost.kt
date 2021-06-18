package com.example.compose_layout_practice_140621.bottomnavigationbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class NavigationHost {

    @Composable
    fun NavigationHost(navController: NavController, viewModel: MainViewModel) {
        NavHost(
            navController = navController as NavHostController,
            startDestination = Screens.DrawerScreens.Home.route
        ) {
            composable(Screens.DrawerScreens.Home.route) { Home(viewModel = viewModel) }
            composable(Screens.HomeScreen.Mails.route) { Mails(viewModel = viewModel) }
            composable(Screens.HomeScreen.Notifications.route) { Notifications(viewModel = viewModel) }
            composable(Screens.HomeScreen.Settings.route) { Settings(viewModel = viewModel) }
            composable(Screens.DrawerScreens.Account.route) { Account(viewModel = viewModel) }
            composable(Screens.DrawerScreens.About.route) { About(viewModel = viewModel) }
            composable(Screens.DrawerScreens.Help.route) { Help(viewModel = viewModel) }
        }
    }

}