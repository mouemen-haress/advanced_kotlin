package com.example.twowaydemo1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twowaydemo1.ui.theme.TwoWayDemo1Theme

class jetPackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }

    }


}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        NormalBtn()
        TextBtn()
        OutLineBtn()
        IconBtn()
        CustomizedBtn()
    }


}

@Composable
fun NormalBtn() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "click normal btn", Toast.LENGTH_LONG).show()
        },
        shape = RectangleShape
    ) {
        Text(text = "Add to cart")
    }
}

@Composable
fun CustomizedBtn() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "click normal btn", Toast.LENGTH_LONG).show()
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        ),
        shape = RectangleShape
    ) {
        Text(
            text = "Add to cart",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun TextBtn() {
    val context = LocalContext.current
    TextButton(onClick = {
        Toast.makeText(context, "hi baby", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "Add to cart")
    }
}

@Composable
fun OutLineBtn() {
    val context = LocalContext.current
    OutlinedButton(onClick = {
        Toast.makeText(context, "hi baby", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "Add to cart")
    }
}

@Composable
fun IconBtn() {
    val context = LocalContext.current
    IconButton(onClick = {
        Toast.makeText(context, "click normal btn", Toast.LENGTH_LONG).show()
    }) {
        Icon(
            Icons.Filled.Phone,
            contentDescription = "dec",
            tint = Color.Blue,
            modifier = Modifier.size(70.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TwoWayDemo1Theme {
        ButtonDemo()
    }
}