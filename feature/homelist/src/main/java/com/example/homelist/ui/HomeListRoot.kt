package com.example.homelist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeListRoot(
    modifier: Modifier = Modifier,
    viewModel: HomeListViewModel = hiltViewModel()
) {
    val state = viewModel.homeListUiState.collectAsState().value

    HomeListScreen(
        modifier = Modifier.fillMaxSize(),
        state = state
    )
}

@Composable
fun HomeListScreen(
    modifier: Modifier,
    state: HomeListUiState
) {
    HomeListContent(
        modifier = modifier,
        userList = when (state) {
            HomeListUiState.Loading -> emptyList()
            HomeListUiState.Failure -> emptyList()
            is HomeListUiState.Success -> state.data
        }
    )
}

@Composable
fun HomeListContent(
    modifier: Modifier,
    userList: List<UserModelUiState>
) {
    Column(
        modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        LazyColumn(
            modifier.padding(10.dp)
        ) {
            items(
                items = userList,
                key = { items -> items.id }
            ) { item ->
                Column(modifier = modifier) {
                    Text(
                        text = item.email,
                    )
                    Text(
                        text = item.name,
                        fontSize = 24.sp
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}


