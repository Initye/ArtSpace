package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    ArtTimeLayout()
                }
            }
        }
    }
}

@Composable
fun ArtTimeLayout() {
    var result by remember { mutableIntStateOf(1) } //remember to import getValue to make it work

    val titleResource = when (result) {
        1 -> R.string.art_title_1
        2 -> R.string.art_title_2
        3 -> R.string.art_title_3
        4 -> R.string.art_title_4
        else -> R.string.art_title_5
    }

    val authorResource = when (result) {
        1 -> R.string.author_name_1
        2 -> R.string.author_name_2
        3 -> R.string.author_name_3
        4 -> R.string.author_name_4
        else -> R.string.author_name_5
    }

    val imageResource = when (result) {
        1 -> R.drawable.art_image_1
        2 -> R.drawable.art_image_2
        3 -> R.drawable.art_image_3
        4 -> R.drawable.art_image_4
        else -> R.drawable.art_image_5

    }

    Column (
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "\"${stringResource(titleResource)}\"", //quotation marks
            style = TextStyle(
                fontWeight = FontWeight.Bold,//bold font
                fontSize = 30.sp
            ),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)

        )


        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {

//I HAVE NO IDEA HOW TO DO BLURRED BORDER AROUND IMAGE AS OF NOW
//            val borderBlur = @Composable {
//                Box(modifier = Modifier
//                    .border(BorderStroke(5.dp, color = colorResource(R.color.black)))
////                    .fillMaxSize()
//                    .matchParentSize()
////                    .blur(50.dp)
//                )
//            }
//            borderBlur()

//UNUSED BORDER, IF YOU WANT TO USE IT REPLACE BorderStroke WITH IT
//    val borderBrush = Brush.linearGradient(
//        0.0f to Color.Black,
//        1.0f to Color.Gray,
//        start = Offset(100.0f, 0.0f),
//        end = Offset(0.0f, 100.0f)
//    )

            Image(
                painter = painterResource(imageResource),
                contentDescription = "",
                modifier = Modifier
                    .padding(5.dp)
                    .border(
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Black
                        )
                    )
                    .wrapContentSize()
            )
        }

        Text(
            text = stringResource(authorResource),
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
        Row(
            horizontalArrangement = Arrangement.spacedBy(50.dp), //making space between buttons
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 25.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Button(
                onClick = {
                        result = if (result > 1) result - 1 else 1
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .weight(1f) //by using with .weight (on buttons modifiers) the buttons are the same size
            ) {
                Text(text = "Previous")
            }
            Button (
                onClick = {
                    result = if (result < 5) result + 1 else 1 //when the result is smaller than 5 increment, else return to 1
                },
                modifier = Modifier
                    .padding(top=16.dp)
                    .weight(1f)
            ) {
                Text(text = "Next")
            }
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtTimeLayout()
    }
}