package com.example.twowaydemo1.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.twowaydemo1.data.ConversionReults


@Composable
fun HistoryList(
    list: State<List<ConversionReults>>,
    onCloseTast: (ConversionReults) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            items = list.value,
            key = { i -> i.id }
        ) { item ->
            HistoryItem(
                messageOne = item.messageOne,
                messageTwo = item.messageTwo,
                onClose = {
                    onCloseTast(item)
                })
        }
    }
}