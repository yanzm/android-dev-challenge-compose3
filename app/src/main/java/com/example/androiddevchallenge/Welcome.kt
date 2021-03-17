package com.example.androiddevchallenge

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome(onClick: () -> Unit) {
    Image(
        painter = painterResource(
            id = if (isSystemInDarkTheme()) {
                R.drawable.dark_welcome_bg
            } else {
                R.drawable.light_welcome_bg
            }
        ),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .padding(top = 72.dp)
    ) {
        Image(
            painter = painterResource(
                id = if (isSystemInDarkTheme()) {
                    R.drawable.dark_welcome_illos
                } else {
                    R.drawable.light_welcome_illos
                }
            ),
            contentDescription = "",
            modifier = Modifier
                .requiredSize(width = 310.dp, height = 280.dp)
                .offset(x = 88.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            "Bloom",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(32.dp)
        )

        Text(
            "Beautiful home garden solutions",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 24.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
            ),
            elevation = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .height(48.dp)
        ) {
            Text("Create account")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = { onClick() },
            shape = MaterialTheme.shapes.medium,
            elevation = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(start = 16.dp, end = 16.dp),
        ) {
            Text(
                "Log in",
                color = MaterialTheme.colors.secondary
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Welcome() {

            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomePreviewDark() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Welcome() {

            }
        }
    }
}
