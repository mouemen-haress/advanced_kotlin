package com.example.twowaydemo1

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.twowaydemo1.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat


@Composable
fun TopScreen(
    list: List<Conversion>, context: Context = LocalContext.current,
    save: (String, String) -> Unit
) {
    val selectedConversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inpuText: MutableState<String> = remember { mutableStateOf("") }
    val typedValue = remember { mutableStateOf("0.0") }
    ConversionMenu(list = list) {
        selectedConversion.value = it
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inpuText) { inpuT ->
            typedValue.value = inpuT;
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
        save(messageOne, messageTwo)
        ResultBlock(messageOne = messageOne, messageTwo = messageTwo)
    }

}