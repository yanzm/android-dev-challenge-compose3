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

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    onClick: (Tab) -> Unit,
) {
    androidx.compose.material3.NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier
    ) {
        for (tab in Tab.values()) {
            BottomAppBarItem(
                isSelect = tab == Tab.Home,
                tab = tab,
                onClick
            )
        }
    }
}

@Composable
fun RowScope.BottomAppBarItem(
    isSelect: Boolean,
    tab: Tab,
    onClick: (Tab) -> Unit,
) {
    NavigationBarItem(
        selected = isSelect,
        icon = {
            Icon(
                imageVector = when (tab) {
                    Tab.Home -> Icons.Filled.Home
                    Tab.Favorites -> Icons.Filled.FavoriteBorder
                    Tab.Profile -> Icons.Filled.AccountCircle
                    Tab.Cart -> Icons.Filled.ShoppingCart
                },
                contentDescription = tab.name,
                modifier = Modifier.size(24.dp)
            )
        },
        label = {
            Text(tab.name)
        },
        onClick = { onClick(tab) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = ContentAlpha.disabled),
            selectedTextColor = MaterialTheme.colorScheme.secondary,
            unselectedTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = ContentAlpha.disabled),
            indicatorColor = MaterialTheme.colorScheme.secondary,
        )
    )
}

enum class Tab {
    Home,
    Favorites,
    Profile,
    Cart
}
