package com.example.mealsapp.mealdetail
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun mealdetailscreen(mealId: String) {

    val scrollState = rememberScrollState()
    val viewModel: mealdetailviewmodel = viewModel()

    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val inst by viewModel.mealDetail.collectAsState(null)

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFBafaeb)),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = androidx.compose.ui.Modifier
                .background(Color(0xFFBafaeb))
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(3.dp)
        ) {
            if (inst != null) {

                //Instructions ->Composable
                Text(
                    text = inst!!.meals?.first()?.strInstructions ?: "No instructions available",
                    fontSize = 18.sp
                )
            } else {
            }
        }
    }

}