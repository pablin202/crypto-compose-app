package com.pdm.cryptocurrencyapp.domain.use_case.get_coin

import com.pdm.cryptocurrencyapp.domain.data.repository.FakeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCoinUseCaseTest {

    private lateinit var getCoinUseCase : GetCoinUseCase
    private lateinit var repository: FakeRepository

    @Before
    fun setup() {
        repository = FakeRepository()
        getCoinUseCase = GetCoinUseCase(repository)
    }

    @Test
    fun `coin detail symbol should be BTC` () = runBlockingTest {
        val coin = getCoinUseCase("").first()
        coin.data?.let {
            assert(it.symbol == MOCK_BTC_SYMBOL)
        }
    }

    companion object {
        const val MOCK_BTC_SYMBOL = "BTC"
    }
}