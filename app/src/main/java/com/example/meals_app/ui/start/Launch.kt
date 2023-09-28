package com.example.meals_app.ui.start

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meals_app.R


@Preview
@Composable
fun LaunchScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF16C6CF), Color.Blue),
                    startY = 0f,
                    endY = 2000f // Adjust the endY value as needed
                )
            )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
            ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Text(text = "App tittle")
                LaunchImage()
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Go")
                }
            }
        }

    }

}

@Composable
fun LaunchImage(){
    Image(
        modifier = Modifier.size(250.dp),
        painter = painterResource(id = R.drawable.taco) ,
        contentDescription = null)
}