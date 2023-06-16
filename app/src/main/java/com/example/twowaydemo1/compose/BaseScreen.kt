package com.example.twowaydemo1

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import com.example.twowaydemo1.compose.converter.TopScreen
import com.example.twowaydemo1.compose.history.HistoryScreen


@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConvertViewModel = viewModel(factory = factory)
) {

    val list = converterViewModel.getConversion()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandscape by remember { mutableStateOf(false) }


    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandscape = true
            Row(
                modifier = modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inpuText,
                    converterViewModel.typedValue,
                    isLandscape,
                    converterViewModel.dsiplayingText
                ) { messageOne, messageTwo ->
                    converterViewModel.addResult(messageOne, messageTwo)
                }
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(
                    historyList, {
                        converterViewModel.removeResult(it)
                    },
                    {
                        converterViewModel.removeAll()
                    }, isLandscape
                )
            }

        }

        Configuration.ORIENTATION_PORTRAIT -> {
            isLandscape = false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inpuText,
                    converterViewModel.typedValue,
                    isLandscape,
                    converterViewModel.dsiplayingText
                ) { messageOne, messageTwo ->
                    converterViewModel.addResult(messageOne, messageTwo)
                }
                Spacer(modifier = modifier.height(20.dp))
                HistoryScreen(
                    historyList, {
                        converterViewModel.removeResult(it)
                    },
                    {
                        converterViewModel.removeAll()
                    },
                    isLandscape
                )
            }

        }
    }


}