package com.example.twowaydemo1.compose.history

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import com.example.twowaydemo1.data.ConversionReults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HistoryScreen(
    list: State<List<ConversionReults>>,
    onCloseTasc: (ConversionReults) -> Unit,
    onClearAllTasc: () -> Unit,
    isLandscape: Boolean,
    modifier: Modifier = Modifier
) {

    Column() {
        if (list.value.isNotEmpty()) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "History", color = Color.Gray)
                OutlinedButton(onClick = { onClearAllTasc() }) {
                    Text(
                        text = "Clear All",
                        color = Color.Gray
                    )
                }
            }
        }
        HistoryList(list = list, onCloseTast = {
            onCloseTasc(it)
        })
    }

}