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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Home()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.navigationBarsPadding(),
                onClick = { }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            SearchComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp)
            ) {
                items(BrowseThemes.values()) { theme ->
                    BrowseThemesCard(theme)
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                        .weight(1f)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.FilterList,
                        contentDescription = "sort",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            for ((i, garden) in DesignHomeGarden.values().withIndex()) {
                MyListItem(i = i, garden = garden)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun SearchComponent(modifier: Modifier = Modifier) {
    var searchValue by remember { mutableStateOf("") }

    TextField(
        value = searchValue,
        onValueChange = { searchValue = it },
        placeholder = "Search",
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search",
                modifier = Modifier.size(18.dp)
            )
        },
        modifier = modifier
    )
}

@Composable
fun BrowseThemesCard(item: BrowseThemes) {
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = MaterialTheme.colorScheme.surface.compositeOver(MaterialTheme.colorScheme.background),
        contentColor = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .padding(4.dp)
            .size(136.dp)
            .clickable {
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
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
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

    Row {
        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(garden.image),
            contentDescription = garden.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(modifier = Modifier.height(64.dp)) {
            Text(
                text = garden.title,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(start = 8.dp)
            )

            Text(
                text = garden.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp)
                    .padding(start = 8.dp)
            )

            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.secondary,
                    uncheckedColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    checkmarkColor = MaterialTheme.colorScheme.background,
                    disabledColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.disabled),
                ),
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.TopEnd)
            )

            Divider(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(end = 16.dp)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Preview(widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    MyTheme {
        HomeScreen()
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
