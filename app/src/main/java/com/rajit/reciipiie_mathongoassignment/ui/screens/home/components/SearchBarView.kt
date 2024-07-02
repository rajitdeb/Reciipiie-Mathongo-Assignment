package com.rajit.reciipiie_mathongoassignment.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun SearchBarView(
    isFunctional: Boolean = false,
    onSearchClicked: () -> Unit = {},
    onBackClicked: () -> Unit
) {

    var text by remember { mutableStateOf("") }

    if(!isFunctional) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F7FD)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.clickable { if(!isFunctional) { onSearchClicked() } }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                // Search Icon
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )

                Spacer(modifier = Modifier.width(10.dp))

                // Search Bar Hint Text
                Text(
                    "Search any recipe",
                    color = Color(0xFF606F89),
                    fontSize = 16.sp
                )

            }
        }
    } else {
        TextField(
            value = text,
            onValueChange = { text = it },
            leadingIcon = {
                IconButton(onClick = { if(isFunctional) { onBackClicked() } }) {
                    Icon(
                        imageVector = if(!isFunctional) Icons.Filled.Search else Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Search Icon"
                    )
                }
            },
            trailingIcon = {
                if(text.trim().isNotEmpty()) {
                    IconButton(onClick = { text = "" }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear Text Icon"
                        )
                    }
                }
            },
            placeholder = { Text("Search any recipe") },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF2F7FD),
                focusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFFF2F7FD),
                unfocusedIndicatorColor = Color.Transparent,
                selectionColors = TextSelectionColors(
                    handleColor = Color(0xFF94C3FC),
                    backgroundColor = Color(0xFF94C3FC)
                ),
                cursorColor = Color(0xFF94C3FC)
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}