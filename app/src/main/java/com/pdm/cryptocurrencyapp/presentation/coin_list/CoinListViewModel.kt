package com.pdm.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm.cryptocurrencyapp.common.Resource
import com.pdm.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CoinListState>(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoinsUseCase().onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> CoinListState(coins = result.data ?: emptyList())
                is Resource.Error -> CoinListState(error = result.message ?: "")
                is Resource.Loading -> CoinListState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}