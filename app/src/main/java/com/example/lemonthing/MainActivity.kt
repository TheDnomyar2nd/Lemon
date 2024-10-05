package com.example.lemonthing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonthing.ui.theme.LemonThingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonThingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var result by remember { mutableIntStateOf(1) }
                    LemonImageAndText()
                }
            }
        }
    }
}



@Composable
fun LemonImageAndText(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var randomPresses  by remember { mutableIntStateOf((1..4).random())}

    when(result) {
        1 -> {
            Column {
                Button(onClick = {result += 1}) {
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree_content_description)
                    )
                }

                Spacer(Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.lemon_select),
                    modifier = modifier
                )
            }
        }
        2 -> {
            Column {
                Button(onClick = {randomPresses -= 1
                    if (randomPresses == 0) {
                        result += 1 }}) {

                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.lemon_content_description)
                    )
                }

                Spacer(Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.lemon_squeeze),
                    modifier = modifier
                )
            }
        }
        3 -> {
            Column {
                Button(onClick = {result += 1}) {
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemonade_content_description)
                    )
                }

                Spacer(Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.lemon_drink),
                    modifier = modifier
                )
            }
        }
        4 -> {
            Column {
                Button(onClick = {result = 1}) {
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.empty_glass_content_description)
                    )
                }

                Spacer(Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.lemon_empty_glass),
                    modifier = modifier
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonThingTheme {
        LemonImageAndText()
    }
}