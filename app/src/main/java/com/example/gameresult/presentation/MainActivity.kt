/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.gameresult.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.*
import com.example.gameresult.presentation.theme.GameResultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun WearApp() {
    GameResultTheme {

        val home: MutableState<Int> = mutableStateOf(0)
        val away: MutableState<Int> = mutableStateOf(0)

        Row {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = 0.5f)
                    .background(MaterialTheme.colors.primaryVariant),
                verticalArrangement = Arrangement.Center
            )
            {
                TeamScore(home)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.secondaryVariant),
                verticalArrangement = Arrangement.Center
            ) {
                TeamScore(away)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Button(onClick = {
                home.value = 0
                away.value = 0
            }) {
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    contentDescription = "triggers phone action",
                )
            }
        }
    }
}

@Composable
fun TeamScore(score: MutableState<Int>) {

    Button(onClick = { score.value++ }) {

        Text(
            text = "${score.value}",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,

            )
    }

}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}