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
package com.example.androiddevchallenge

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(32.dp))
//            Spacer(modifier = Modifier.height(40.dp))

            SearchComponent()

            Header(
                text = "Browse themes",
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp)
            )

            BrowseThemesRow()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Header(
                    text = "Design your home garden",
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                        .weight(1f)
                )
                IconButton(
                    onClick = {
                        // TODO
                    },
                    modifier = Modifier
                        .padding(top = 14.dp)
                        .size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.FilterList,
                        contentDescription = "sort",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }

            for ((i, garden) in DesignHomeGarden.values().withIndex()) {
                MyListItem(i = i, garden = garden)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        MyBottomAppBar {
            for (tab in Tab.values()) {
                BottomAppBarItem(
                    isSelect = tab == Tab.Home, tab = tab,
                    onClick = {
                        // TODO
                    }
                )
            }
        }
    }
}

@Composable
fun SearchComponent() {
    var searchValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchValue,
        onValueChange = { searchValue = it },
        placeholder = {
            Text(
                "Search",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onBackground
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search",
                modifier = Modifier.size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun Header(text: String, modifier: Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onBackground,
        modifier = modifier
    )
}

@Composable
fun BrowseThemesRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        val values = BrowseThemes.values()
        val last = values.lastIndex
        for ((i, item) in values.withIndex()) {
            BrowseThemesCard(i == 0, i == last, item)
        }
    }
}

@Composable
fun BrowseThemesCard(isFirst: Boolean, isLast: Boolean, item: BrowseThemes) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface.compositeOver(MaterialTheme.colors.background),
        contentColor = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = if (isFirst) 16.dp else 8.dp,
                end = if (isLast) 16.dp else 0.dp,
            )
            .size(136.dp)
            .clickable {
                // TODO
            },
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(96.dp),
            )
            Text(
                text = item.text,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 24.dp)
                    .padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun MyListItem(i: Int, garden: DesignHomeGarden) {
    var isChecked by remember { mutableStateOf(i == 0) }

    Row(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = garden.image),
            contentDescription = garden.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.small)
        )

        Box(
            modifier = Modifier
                .height(64.dp)
                .padding(start = 8.dp)
        ) {
            Text(
                text = garden.title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(start = 8.dp)
            )
            Text(
                text = garden.description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .paddingFromBaseline(bottom = 24.dp)
                    .padding(start = 8.dp)
                    .align(Alignment.BottomStart)
            )

            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = MaterialTheme.colors.background
                ),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp)
            )

            Divider(
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )
        }
    }
}

@Composable
fun MyBottomAppBar(content: @Composable RowScope.() -> Unit) {
    BottomAppBar(
        elevation = 16.dp,
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.height(56.dp),
        contentPadding = PaddingValues(
            start = 0.dp,
            end = 0.dp
        ),
        content = content
    )
}

@Composable
fun RowScope.BottomAppBarItem(
    isSelect: Boolean,
    tab: Tab,
    onClick: (Tab) -> Unit,
    selectedContentColor: Color = LocalContentColor.current,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium)
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clickable {
                onClick(tab)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = when (tab) {
                Tab.Home -> Icons.Filled.Home
                Tab.Favorites -> Icons.Filled.FavoriteBorder
                Tab.Profile -> Icons.Filled.AccountCircle
                Tab.Cart -> Icons.Filled.ShoppingCart
            },
            contentDescription = tab.name,
            tint = if (isSelect) selectedContentColor else unselectedContentColor,
            modifier = Modifier.size(24.dp)
        )
        Text(
            tab.name,
            style = MaterialTheme.typography.caption,
            color = if (isSelect) selectedContentColor else unselectedContentColor,
        )
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Home()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreviewDark() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Home()
        }
    }
}

enum class BrowseThemes(val text: String, val image: Int) {
    DesertChic("Desert chic", R.drawable.image_desert_chic),
    TinyTerrariums("Tiny terrariums", R.drawable.image_tiny_terrariums),
    JangleVibes("Jungle vibes", R.drawable.image_jungle_vibes),
    EasyCase("Easy care", R.drawable.image_easy_care),
    Statements("Statements", R.drawable.image_statements)
}

enum class DesignHomeGarden(val title: String, val description: String, val image: Int) {
    Monstera("Monstera", "This is a description", R.drawable.image_monstera),
    Aglaonema("Aglaonema", "This is a description", R.drawable.image_aglaonema),
    PeaceLily("Peace lily", "This is a description", R.drawable.image_peace_lily),
    FiddleLeafTree("Fiddle leaf tree", "This is a description", R.drawable.image_fiddle_leaf_tree),
    SnakePlant("Snake plant", "This is a description", R.drawable.image_snake_plant),
    Pothos("Pothos", "This is a description", R.drawable.image_pothos),
}

enum class Tab {
    Home,
    Favorites,
    Profile,
    Cart
}
