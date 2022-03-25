package com.example.tipcalculator.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

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
            valueRange = 0f..100f,
            steps = 10
        )
    }

}