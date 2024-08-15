package com.example.paging_demo.navigation

const val HOME_GRAPH_ROUTE = "home"
const val ROOT_GRAPH_ROUTE = "root"
sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Search : Screen(route = "search_screen")
}