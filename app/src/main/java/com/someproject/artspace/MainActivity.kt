package com.someproject.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.someproject.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentPosition by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(50.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(4F)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentPosition) {
                1 -> ImageWithText(
                    image = R.drawable.pexels_alin_luna,
                    author = "Alin Luna",
                    date = "Posted on March 18th, 2021",
                    modifier = Modifier
                )
                2 -> ImageWithText(
                    image = R.drawable.pexels_kevin_gamba,
                    author = "Kevin Gamba",
                    date = "Posted on September 30th, 2021",
                    modifier = Modifier
                )
                3 -> ImageWithText(
                    image = R.drawable.pexels_paul_blenkhorn,
                    author = "Paul Blenkhorn",
                    date = "Posted on September 14th, 2021",
                    modifier = Modifier
                )
                4 -> ImageWithText(
                    image = R.drawable.pexels_steve_johnson,
                    author = "Steve Johnson",
                    date = "Posted on March 18th, 2021",
                    modifier = Modifier
                )
                else -> ImageWithText(
                    image = R.drawable.pexels_tamanna_rumee,
                    author = "Tamanna Rumee",
                    date = "Posted on July 15th, 2021",
                    modifier = Modifier
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1F)
                .wrapContentSize(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row() {
                Button(modifier = Modifier
                    .weight(1F)
                    .padding(end = 10.dp),
                    onClick = {
                        currentPosition = previousButton(currentPosition)
                    }) {
                    Text(text = stringResource(R.string.previous))
                }
                Button(modifier = Modifier
                    .weight(1F)
                    .padding(start = 10.dp),
                    onClick = {
                        currentPosition = nextButton(currentPosition)
                    }) {
                    Text(text = stringResource(R.string.next))
                }
            }
        }

    }
}

@VisibleForTesting
internal fun previousButton(currentPosition: Int): Int {
    var position = currentPosition
    if (position > 1) {
        position -= 1
    }
    return position
}

@VisibleForTesting
internal fun nextButton(currentPosition: Int): Int {
    var position = currentPosition
    if (position < 5) {
        position += 1
    }
    return position
}

@Composable
fun ImageWithText(image: Int, author: String, date: String, modifier: Modifier) {
    Card(elevation = 5.dp) {
        Image(
            painter = painterResource(id = image),
            contentDescription = image.toString(),
            modifier = modifier
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(2.dp))
                // .shadow(10.dp, shape = RectangleShape, clip = false)
                .padding(20.dp)

        )
    }


    Spacer(modifier = modifier.height(40.dp))

    Card(elevation = 10.dp) {
        Column(modifier = modifier.padding(20.dp)) {
            Text(text = author, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = date)
        }

    }

    Spacer(modifier = modifier.height(40.dp))

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}