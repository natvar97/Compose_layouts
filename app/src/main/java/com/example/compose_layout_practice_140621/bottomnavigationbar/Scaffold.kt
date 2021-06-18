package com.example.compose_layout_practice_140621.bottomnavigationbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose_layout_practice_140621.Drawer
import kotlinx.coroutines.launch

class Scaffold {

    @Composable
    fun AppScaffold() {

        val viewModel: MainViewModel = viewModel()

        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val currentScreen by viewModel.currentScreen.observeAsState()

        var topBar: @Composable () -> Unit = {
            TopAppBar(
                title = { currentScreen!!.title },
                navigationIcon = { Icons.Filled.Menu }

            )
        }

        if (currentScreen == Screens.DrawerScreens.Help) {
            topBar = {
                TopAppBar(
                    title = { currentScreen!!.title },
                    navigationIcon = { Icons.Filled.Menu }

                )

            }
        }

        val bottomBar: @Composable () -> Unit = {
            if (currentScreen == Screens.DrawerScreens.Home || currentScreen is Screens.HomeScreen) {
                BottomNavigationBar().BottomNavBar(
                    screens = screensInHomeFromBottomNav,
                    navController = navController
                )
            }
        }

        Scaffold(
            topBar = {
                topBar()
            },
            bottomBar = {
                bottomBar()
            },
            drawerContent = {
                Drawer(){}
            },
            scaffoldState = scaffoldState,
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        ) { innerPadding ->
            NavigationHost().NavigationHost(navController, viewModel)
        }


    }


}