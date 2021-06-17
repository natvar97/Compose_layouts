package com.example.compose_layout_practice_140621.drawer

import com.example.compose_layout_practice_140621.*

sealed class DrawerScreens(val title: String, val route: String) {
    object Home : MainActivity("Home", "home")

    object Hotels : StateWiseHotelList("Hotels", "hotels")
    object TopDestinations : TopDestinationsListActivity("Top Destinations", "top destinations")
    object UserProfile : UserProfileActivity("User Profile", "user profile")
    object Movies : MoviesListByCategories("Movies", "movies")
    object About : DescriptionActivity("About", "about")
    object Register : SignupActivity("Register", "register")
}
