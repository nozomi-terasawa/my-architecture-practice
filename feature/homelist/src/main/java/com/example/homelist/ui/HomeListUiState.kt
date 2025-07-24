package com.example.homelist.ui


sealed interface HomeListUiState {
    data object Loading : HomeListUiState
    data object Failure : HomeListUiState
    data class Success(val data: List<UserModelUiState>) : HomeListUiState
}
