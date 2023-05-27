package com.example.twowaydemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twowaydemo1.ui.theme.TwoWayDemo1Theme

class jetPackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Columntutorial("Android")
            rowtutorial("Android")
        }

    }
}


@Composable
fun rowtutorial(name: String) {
    Row(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxSize(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        sub("AB")
        sub("CD")
        sub("EF")
    }


}

@Composable
fun sub(name: String) {
    Text(
        text = name,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Blue)
            .padding(10.dp)
    )

}

@Composable
fun Columntutorial(name: String) {
    Column(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        sub("slall")
        sub(name)
        sub(name)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TwoWayDemo1Theme {
//        Columntutorial("sami")
        rowtutorial(name = "Android")
    }
}