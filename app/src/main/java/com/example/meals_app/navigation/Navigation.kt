package com.example.meals_app.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meals_app.ui.categories.Categories
import com.example.meals_app.ui.start.LaunchScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Preview
@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController,  startDestination = Model.LaunchScreen.route) {

        //Main screen first one
        composable(route = Model.LaunchScreen.route) {
            LaunchScreen(navController = navController)
        }

        composable(route = Model.Categories.route) {
            Categories(navController = navController)
        }
    }
}