/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(
    onClickLogin: () -> Unit = {},
) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        WelcomeContent(
            onClickCreateAccount = {},
            onClickLogin = onClickLogin
        )
    }
}

@Composable
private fun WelcomeContent(
    onClickCreateAccount: () -> Unit,
    onClickLogin: () -> Unit,
) {
    Image(
        painter = painterResource(R.drawable.welcome_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(72.dp))

        Image(
            painter = painterResource(R.drawable.welcome_illos),
            contentDescription = "",
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            "Beautiful home garden solutions",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 32.dp, bottom = 40.dp)
        )

        Button(
            text = "Create account",
            onClick = onClickCreateAccount,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            text = "Log in",
            onClick = onClickLogin,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Preview(widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomePreview() {
    MyTheme {
        WelcomeScreen()
    }
}
