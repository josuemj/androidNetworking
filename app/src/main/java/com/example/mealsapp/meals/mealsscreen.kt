package com.example.mealsapp.meals.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mealsapp.meals.mealsviewmodel
import com.example.mealsapp.navigation.Screens
import com.example.mealsapp.navigation.response.MealResponse
import com.example.mealsapp.uielements.categoryCard
import com.example.mealsapp.uielements.mealCard
import com.example.mealsapp.uielements.topbar


@Composable
fun Mealsscreen(navController: NavController) {
    val viewModel: mealsviewmodel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEbce90)),
        contentAlignment = Alignment.TopCenter
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            topbar(tittle = "Meal Categorries", Color(0xFFEbce90))

            LazyColumn {
                items(rememberedMeals.value) { meal ->

                    mealCard(
                        navController = navController,
                        mealName = AnnotatedString(text = meal.name)
                    )

                }
            }
        }


    }

}