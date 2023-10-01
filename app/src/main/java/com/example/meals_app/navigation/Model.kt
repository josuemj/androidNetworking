package com.example.meals_app.navigation

sealed class Model(val route:String){

    object LaunchScreen : Model("launch_screen")
    object Categories : Model("categories")


}