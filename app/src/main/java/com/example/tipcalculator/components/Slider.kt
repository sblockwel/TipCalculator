package com.example.tipcalculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun informaPercent(valor: Int, onPercentChange: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
    ) {
        Slider(
            value = valor.toFloat(),
            onValueChange = { onPercentChange(it.toInt()) },
            valueRange = 0f..30f,
            modifier = Modifier.size(height = 20.dp, width = 200.dp)
        )
        /*OutlinedTextField(
            value = valor.toString(),
            onValueChange = {
                var valorChange = valor
                if (it.length == 0) {
                    valorChange = 0
                } else {
                    if (it.isDigitsOnly() && it.length > 0) {
                        valorChange = it.toInt()
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )*/
    }

}