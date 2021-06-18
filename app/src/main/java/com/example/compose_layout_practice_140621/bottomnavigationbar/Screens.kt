package com.example.compose_layout_practice_140621.bottomnavigationbar

import com.example.compose_layout_practice_140621.R

sealed class Screens(val route: String, val title: String) {

    sealed class HomeScreen(
        route: String,
        title: String,
        val icon: Int
    ) : Screens(route, title) {
        object Mails : HomeScreen("mail", "Mail", R.drawable.icon_mail_white)
        object Notifications :
            HomeScreen("notifications", "Notifications", R.drawable.icon_notifications_none_white_)

        object Settings : HomeScreen("settings", "Settings", R.drawable.icon_settings_white)
    }

    sealed class DrawerScreens(
        route: String,
        title: String
    ) : Screens(route, title) {
        object Home : DrawerScreens("home","Home")
        object Account : DrawerScreens("account" ,"Account")
        object About : DrawerScreens("about" ,"About")
        object Help : DrawerScreens("help" ,"Help")
    }


}

val screensInHomeFromBottomNav = listOf(
    Screens.HomeScreen.Mails,
    Screens.HomeScreen.Notifications,
    Screens.HomeScreen.Settings
)

val screensFromDrawer = listOf(
    Screens.DrawerScreens.Home,
    Screens.DrawerScreens.Account,
    Screens.DrawerScreens.About,
    Screens.DrawerScreens.Help
)
