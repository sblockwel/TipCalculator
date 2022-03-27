package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import com.example.tipcalculator.ui.theme.components.informaPercent
import com.example.tipcalculator.ui.theme.components.informaValor
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val df = DecimalFormat("#.##")

    var valueState by remember {
        mutableStateOf(0f)
    }
    var percentState by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        var calculatePercent = percentState.toFloat() / 100
        val value = if (!valueState.equals("")) valueState else 0
        val percent = if (!percentState.equals("")) calculatePercent else 0

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Valor R$ ")
            informaValor(valueState, onValorChange = { valueState = it })
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Percentual % ")
            informaPercent(percentState, onPercentChange = { percentState = it })
        }

        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 75.dp)
            ) {
                Text(
                    text = "Tip",
                    modifier = Modifier.padding(20.dp)
                )
                Text(
                    text = "Total",
                    modifier = Modifier.padding(20.dp)
                )
            }
            Column(modifier = Modifier.padding(20.dp)) {
                val valueWithTip = value.toFloat() * 0.15

                Text(
                    text = "15%",
                    modifier = Modifier.padding(20.dp)
                )

                OutlinedTextField(
                    value = "R$ ${df.format(valueWithTip)}",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.size(height = 50.dp, width = 120.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    value = "R$ ${df.format(valueWithTip + value.toFloat())}",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.size(height = 50.dp, width = 120.dp)
                )
            }

            Column(modifier = Modifier.padding(20.dp)) {
                val valueWithTip = value.toFloat() * percent.toFloat()

                Text(
                    text = "${percentState}%",
                    modifier = Modifier.padding(20.dp)
                )

                OutlinedTextField(
                    value = "R$ ${df.format(valueWithTip)}",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.size(height = 50.dp, width = 120.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    value = "R$ ${df.format(valueWithTip + value.toFloat())}",
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.size(height = 50.dp, width = 120.dp)
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        App()
    }
}