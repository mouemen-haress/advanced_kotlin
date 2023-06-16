package com.example.twowaydemo1.compose.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.example.twowaydemo1.data.ConversionReults
import androidx.compose.ui.Modifier


@Composable
fun HistoryScreen(
    list: State<List<ConversionReults>>,
    modifier: Modifier = Modifier
) {

    HistoryList(list = list, onCloseTast = {})

}