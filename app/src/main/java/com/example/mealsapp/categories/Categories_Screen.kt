package com.example.mealsapp.categories



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.example.mealsapp.navigation.Screens
import com.example.mealsapp.navigation.response.CategoryResponse
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.mealsapp.uielements.categoryCard
import com.example.mealsapp.uielements.topbar


@Composable
fun categoriesscreen(categoryId: String, navController: NavController) {
    val viewModel: categoriesviewmodel = viewModel()
    val rememberedMeals: MutableState<List<CategoryResponse>> = remember { mutableStateOf(emptyList<CategoryResponse>()) }

    viewModel.getCategory(categoryId) { response ->
        if (response != null) {
            rememberedMeals.value = response.categories.orEmpty()
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF227a9d)),
        contentAlignment = Alignment.TopCenter
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            topbar(tittle = "Meals",Color(0xFF74bedb))

            LazyColumn {
                items(rememberedMeals.value) { meal ->

                    //Test
                    categoryCard(
                        mealId =meal.idmeal,
                        route = Screens.detail.route,
                        mealName = AnnotatedString(text = meal.name),
                        navController = navController,

                        )
                }
            }
        }


    }
    

}

