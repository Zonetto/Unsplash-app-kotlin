package com.example.paging_demo.navigation.nav_graph

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.paging_demo.navigation.HOME_GRAPH_ROUTE
import com.example.paging_demo.navigation.Screen
import com.example.paging_demo.view.home.HomeScreen
import com.example.paging_demo.view.search.SearchScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@SuppressLint("ComposableNavGraphInComposeScope")
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE,
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Search.route,
        ) {
            SearchScreen(navController = navController)
        }
    }
}