package com.github.ramonrabello.compose.counter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CounterScreenContent()
            }
        }
    }
}

@Composable
fun CounterScreenContent(appState: AppState = AppState()) {
    Padding(16.dp) {
        Column {
            CounterTitle()
            CounterButtons(appState.counterState)
            CounterContent(appState.counterState)
        }
    }
}

@Composable
fun CounterApp(child: @Composable() () -> Unit) {
    MaterialTheme {
        child()
    }
}

@Composable
fun CounterTitle() {
    Column {
        HeightSpacer(8.dp)
        Text(
                text = "Compose Counter",
                style = +themeTextStyle { h4 }
        )
        HeightSpacer(8.dp)
        Text(
                text = "This is a simple counter built entirely using Jetpack Compose",
                style = +themeTextStyle { body1 }
        )
        HeightSpacer(8.dp)
    }
}

//
@Composable
fun CounterContent(state: CounterState) {
    Center {
        Column {
            HeightSpacer(8.dp)
            if (state.count == 0) {
                Text(
                        text = "You didn't clicked yet",
                        style = +themeTextStyle { h4 })
            } else {
                Text(
                        text = "You clicked ${state.count} times",
                        style = +themeTextStyle { h4 })
            }
        }
    }
}


@Composable
fun CounterButtons(state: CounterState) {
    Center {
        Column {
            Button(
                    text = "Count",
                    onClick = {
                        state.count++
                    }
            )
        }
    }
}

// Simplified version of a typical AppState
class AppState(val counterState: CounterState = CounterState())

@Model
class CounterState(var count: Int = 0)