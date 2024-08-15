package com.example.paging_demo.view.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.paging_demo.navigation.SetupNavGraph
import com.example.paging_demo.ui.theme.Paging_DemoTheme

@Composable
fun MainScreen() {
    Paging_DemoTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController)
    }
}