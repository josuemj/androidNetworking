package com.example.mealsapp.uielements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun mealCard(
    mealName: AnnotatedString,
    navController:NavController
)
{
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(5.dp)
            .background(
                shape = RoundedCornerShape(10.dp),
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White,Color(0xFFf1aa35))  // Gradient from Red to Blue
                ))
            .clickable(
                onClick = {
                    navController.navigate("Category/${mealName}")

                }
            )
        , contentAlignment = Alignment.CenterStart
    ){
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = mealName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold

        )
    }
}