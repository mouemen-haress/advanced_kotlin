package com.example.twowaydemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
            BoxExampleThree()
        }

    }
}

@Composable
fun BoxExampleOne() {
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .size(180.dp, 300.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .size(60.dp, 60.dp)
        ) {
        }
        Text(
            text = "hello",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(90.dp, 50.dp)
                .align(Alignment.BottomCenter),

            )
    }
}

@Composable
fun BoxExampleTwo() {
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {
        Text(
            text = "top start",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(120.dp, 50.dp)
                .padding(10.dp)
                .align(Alignment.TopStart)

        )

        Text(
            text = "top end",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(120.dp, 50.dp)
                .padding(10.dp)
                .align(Alignment.TopEnd)

        )



        Text(
            text = "Center",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(120.dp, 50.dp)
                .padding(10.dp)
                .align(Alignment.Center)

        )


        Text(
            text = "CenterEnd",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(120.dp, 50.dp)
                .padding(10.dp)
                .align(Alignment.CenterEnd)

        )

        Text(
            text = "BottomStart",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(120.dp, 50.dp)
                .padding(10.dp)
                .align(Alignment.BottomStart)

        )

        Text(
            text = "BottomCenter",
            style = MaterialTheme.typography.bodyLarge,

            modifier = Modifier
                .background(Color.White)
                .size(120.dp, 50.dp)
                .padding(10.dp)
                .align(Alignment.BottomCenter)

        )
    }
}

@Composable
fun BoxExampleThree() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = "test description "
        )
        Text(
            text = "dec",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        Button(
            onClick = {},
        ) {
            Text(text = "click me ")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TwoWayDemo1Theme {
//        Columntutorial("sami")
        BoxExampleThree()
    }
}