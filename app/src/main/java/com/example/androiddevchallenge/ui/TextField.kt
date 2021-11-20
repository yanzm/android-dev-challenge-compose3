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

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        placeholder = {
            Text(
                placeholder,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colorScheme.onBackground,
            cursorColor = MaterialTheme.colorScheme.secondary,
            errorCursorColor = MaterialTheme.colorScheme.error,
            focusedBorderColor = MaterialTheme.colorScheme.secondary.copy(alpha = ContentAlpha.high),
            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.disabled),
            errorBorderColor = MaterialTheme.colorScheme.error,
            leadingIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = TextFieldDefaults.IconOpacity),
            trailingIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = TextFieldDefaults.IconOpacity),
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            focusedLabelColor = MaterialTheme.colorScheme.secondary.copy(alpha = ContentAlpha.high),
            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground.copy(ContentAlpha.medium),
            errorLabelColor = MaterialTheme.colorScheme.error,
            placeholderColor = MaterialTheme.colorScheme.onBackground,
        ),
        leadingIcon = leadingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        modifier = modifier.defaultMinSize(minHeight = 56.dp)
    )
}
