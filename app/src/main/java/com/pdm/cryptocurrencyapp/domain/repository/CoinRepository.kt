package com.pdm.cryptocurrencyapp.domain.repository

import com.pdm.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.pdm.cryptocurrencyapp.data.remote.dto.CoinDto
import com.pdm.cryptocurrencyapp.domain.model.Coin
import com.pdm.cryptocurrencyapp.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}