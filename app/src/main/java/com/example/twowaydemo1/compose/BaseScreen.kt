package com.example.twowaydemo1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
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

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list) { messageOne, messageTwo ->
            converterViewModel.addResult(messageOne, messageTwo)
        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(historyList)
    }

}