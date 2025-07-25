package com.example.homelist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.UserModel
import com.example.data.UserModelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel
    @Inject
    constructor(
        private val userModelRepository: UserModelRepository,
    ) : ViewModel() {
        // TODO ここから、処理をよく見ること
        val homeListUiState: StateFlow<HomeListUiState> =
            userModelRepository
                .getAllUsers()
                .map<List<UserModel>, HomeListUiState> { userModelList ->
                    HomeListUiState.Success(
                        userModelList.map { user ->
                            UserModelUiState(
                                id = user.id,
                                name = user.name,
                                email = user.email,
                                isActive = user.isActive,
                            )
                        },
                    )
                }.stateIn(
                    viewModelScope,
                    SharingStarted.WhileSubscribed(5000),
                    HomeListUiState.Loading,
                )
    }
