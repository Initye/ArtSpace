package com.example.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Column (
        modifier = Modifier
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text (
            text = stringResource(R.string.art_title),
            style = TextStyle(
                fontWeight = FontWeight.Bold,//bold font
                fontSize = 30.sp),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)

        )
        Image (
            painter = painterResource(R.drawable._448_profilecover_1682290871382),
            contentDescription = "asdsad",
            modifier = Modifier
        )
        Text (
            text = stringResource(R.string.author_name),
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 17.sp),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), //making space between buttons
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth(), //by using with .weight (on buttons modifiers) the buttons are the same size
        ) {
            Button(
                onClick = { /*TODO: Wprowadź logikę kliknięcia tutaj */ },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .weight(1f)
            ) {
                Text(text = "Previous")
            }
            Button (
                onClick = { /*TODO*/},
                modifier = Modifier
                    .padding(top=16.dp)
                    .weight(1f)
            ) {
                Text(text = "Next")
            }
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
