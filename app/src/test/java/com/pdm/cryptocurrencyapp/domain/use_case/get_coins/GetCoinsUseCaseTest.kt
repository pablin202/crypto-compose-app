package com.pdm.cryptocurrencyapp.domain.use_case.get_coins

import com.pdm.cryptocurrencyapp.domain.data.repository.FakeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCoinsUseCaseTest {

    private lateinit var getCoinsUseCase : GetCoinsUseCase
    private lateinit var repository: FakeRepository

    @Before
    fun setup() {
        repository = FakeRepository()
        getCoinsUseCase = GetCoinsUseCase(repository)
    }

    @Test
    fun `coins list should not be empty` () = runBlockingTest {
        val coins = getCoinsUseCase()
        assert(coins.count() > 0)
    }

    @Test
    fun `first coin should be BTC` () = runBlockingTest {
        val coin = getCoinsUseCase().first()
        coin.data?.get(0)?.let {
            assert(it.symbol == MOCK_BTC_SYMBOL)
        }
    }

    @Test
    fun `second coin should be ETH` () = runBlockingTest {
        val coin = getCoinsUseCase().first()
        coin.data?.get(1)?.let {
            assert(it.symbol == MOCK_ETH_SYMBOL)
        }
    }

    companion object {
        const val MOCK_BTC_SYMBOL = "BTC"
        const val MOCK_ETH_SYMBOL = "ETH"
    }
}