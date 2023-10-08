package com.example.mealsapp.navigation

sealed class Screens(val route: String) {
    object inicio: Screens("mainscreen")
    object category: Screens("category/{categoryId}")
    object detail: Screens("detail/{mealId}")

}