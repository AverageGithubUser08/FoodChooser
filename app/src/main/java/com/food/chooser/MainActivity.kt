package com.food.chooser

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.food.chooser.ui.theme.FoodChooserTheme
import kotlin.random.Random
import com.food.chooser.Food

class MainActivity : ComponentActivity() {

    private lateinit var food: Food;


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodChooserTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    Box (
                        modifier = Modifier.fillMaxSize()
                            .background(Color.Cyan)
                    )

                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Can't decide\n what to eat?",
                            modifier = Modifier.padding(top = 16.dp),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        MyButton(food);
                    }
                }
            }

        }
        food = Food(this);
    }

    @Composable
    fun MyButton(food: Food) {

        var randomfood by remember { mutableStateOf<String?>(null) };

        Button(
            onClick = { randomfood = food.randomFood() },
            colors = buttonColors(containerColor = Color.Red),
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
        ) {
            Text(
                text = "Choose random Food",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        randomfood?.let {
            Text(
                text = "$it",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        FoodChooserTheme {
            Text(
                text = "What do you want to eat today?",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

