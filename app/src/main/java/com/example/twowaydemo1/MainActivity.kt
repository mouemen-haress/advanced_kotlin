package com.example.twowaydemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.twowaydemo1.data.ConverterDataBase
import com.example.twowaydemo1.data.ConverterRepositoryImp
import com.example.twowaydemo1.ui.theme.TwoWayDemo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = ConverterDataBase.getInstance(applicationContext).converterDAO
        val repository = ConverterRepositoryImp(dao)
        val factory = ConverterViewModelFactory(repository = repository)


        setContent {
            TwoWayDemo1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}


