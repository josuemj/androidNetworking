package com.example.mealsapp.categories



import com.example.mealsapp.navigation.Screens
import com.example.mealsapp.navigation.response.CategoryResponse
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun categoriesscreen(categoryId: String, navController: NavController) {
    val viewModel: categoriesviewmodel = viewModel()
    val rememberedMeals: MutableState<List<CategoryResponse>> = remember { mutableStateOf(emptyList<CategoryResponse>()) }

    viewModel.getCategory(categoryId) { response ->
        if (response != null) {
            rememberedMeals.value = response.categories.orEmpty()
        }
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            ClickableText(
                text = AnnotatedString(text = meal.name),
                onClick = { offset ->
                    navController.navigate("${Screens.detail.route}/${meal.idmeal}")
                }
            )
        }
    }
}

