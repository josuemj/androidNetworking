package com.example.mealsapp.mealdetail
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun mealdetailscreen(mealId: String) {

    val viewModel: mealdetailviewmodel = viewModel()

    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val inst by viewModel.mealDetail.collectAsState(null)

    Column {
        if (inst != null) {

            //Instructions ->Composable
            Text(text = inst!!.meals?.first()?.strInstructions ?: "No instructions available")
        } else {
        }
    }
}