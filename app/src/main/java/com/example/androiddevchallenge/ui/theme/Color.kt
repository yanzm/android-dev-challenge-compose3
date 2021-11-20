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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val pink100 = Color(0xFFFFF1F1)
val pink900 = Color(0xFF3F2C2C)
val gray = Color(0xFF232323)
val green300 = Color(0xFFB8C9B8)
val green900 = Color(0xFF2D3B2D)
val white150 = Color.White.copy(alpha = 0.15f)
val white850 = Color.White.copy(alpha = 0.85f)

val LightColorScheme = darkColorScheme(
    primary = pink100,
    onPrimary = gray,

    secondary = pink900,
    onSecondary = Color.White,

    background = Color.White,
    onBackground = gray,

    surface = white850,
    onSurface = gray,
)

val DarkColorScheme = lightColorScheme(
    primary = green900,
    onPrimary = Color.White,

    secondary = green300,
    onSecondary = gray,

    background = gray,
    onBackground = Color.White,

    surface = white150,
    onSurface = white850,
)
