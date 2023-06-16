package com.example.twowaydemo1.compose.converter

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.twowaydemo1.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat


@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inpuText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandscape: Boolean,
    dsiplayingText: MutableState<String>,
    save: (String, String) -> Unit
) {

    var toSave by remember { mutableStateOf(false) }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ConversionMenu(list = list, isLandscape, dsiplayingText) {
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inpuText, isLandscape) { inpuT ->
                typedValue.value = inpuT;
                toSave = true
            }
        }

        if (typedValue.value != "0.0") {
            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value!!.multipleBy

            val res = input * multiply
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedRes = df.format(res)

            val messageOne =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to "
            val messageTwo = "${roundedRes} ${selectedConversion.value!!.convertTo}"

            if (toSave) {
                save(messageOne, messageTwo)
                toSave = false
            }
            ResultBlock(messageOne = messageOne, messageTwo = messageTwo)
        }
    }

}