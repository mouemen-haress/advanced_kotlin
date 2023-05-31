package com.example.twowaydemo1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.twowaydemo1.ui.theme.TwoWayDemo1Theme

class jetPackActivity : ComponentActivity() {/*
    *       <State Hosting design Pattern> Unidirectional Data flow
    *We are sending state from caller to the composable.
    * And we are sending event from composable to the caller.
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MyViewModel>()

            TwoWayDemo1Theme() {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // state hosting design pattern
                    val count = viewModel.count
                    MyButton(count, {
                        viewModel.increaseCount()
                    })
                }
            }


        }

    }


}


//val count = mutableStateOf(0)

@Composable
fun MyButton(currentCount: Int, updateCount: (Int) -> Unit) {
    val context = LocalContext.current
    Button(
        onClick = {
            updateCount(currentCount)
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.DarkGray, contentColor = Color.White
        ),
        shape = RectangleShape
    ) {
        Text(
            text = "${currentCount}",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(5.dp)
        )

    }


}