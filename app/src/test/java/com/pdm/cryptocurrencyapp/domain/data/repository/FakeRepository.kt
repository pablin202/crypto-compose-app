package com.pdm.cryptocurrencyapp.domain.data.repository

import com.pdm.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.pdm.cryptocurrencyapp.data.remote.dto.CoinDto
import com.pdm.cryptocurrencyapp.data.remote.dto.Links
import com.pdm.cryptocurrencyapp.data.remote.dto.Whitepaper
import com.pdm.cryptocurrencyapp.domain.repository.CoinRepository

class FakeRepository : CoinRepository {

    private val coins = mutableListOf<CoinDto>()
    private val coin = CoinDetailDto(
        description = "",
        developmentStatus = "",
        firstDataAt = "",
        hardwareWallet = false,
        hashAlgorithm = "",
        id = "",
        isActive = false,
        isNew = false,
        lastDataAt = "",
        links = Links(
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        ),
        linksExtended = mutableListOf(),
        message = "",
        name = "",
        openSource = false,
        orgStructure = "",
        proofType = "",
        rank = 1,
        startedAt = "",
        symbol = "BTC",
        tags = mutableListOf(),
        team = mutableListOf(),
        type = "",
        whitepaper = Whitepaper("", "")
    )

    init {
        coins.addAll(
            listOf(
                CoinDto(
                    id = "id",
                    isActive = true,
                    isNew = false,
                    name = "Bitcoin",
                    rank = 1,
                    symbol = "BTC",
                    type = ""
                ),
                CoinDto(
                    id = "id2",
                    isActive = true,
                    isNew = false,
                    name = "Ethereum",
                    rank = 2,
                    symbol = "ETH",
                    type = ""
                )
            )
        )
    }

    override suspend fun getCoins(): List<CoinDto> {
        return coins
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coin
    }
}