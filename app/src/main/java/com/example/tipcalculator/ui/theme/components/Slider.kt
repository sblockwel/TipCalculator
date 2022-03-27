package com.example.tipcalculator.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly

@Composable
fun informaPercent(valor: Int, onPercentChange: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Percentual % ")
        Slider(
            value = valor.toFloat(),
            onValueChange = { onPercentChange(it.toInt()) },
            valueRange = 0f..30f,

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