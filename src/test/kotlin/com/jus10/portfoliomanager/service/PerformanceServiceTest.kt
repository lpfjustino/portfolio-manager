package com.jus10.portfoliomanager.service
import com.jus10.portfoliomanager.model.Acquisition
import com.jus10.portfoliomanager.model.Asset
import com.jus10.portfoliomanager.repository.AcquisitionRepository
import com.jus10.portfoliomanager.repository.AssetRepository
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.time.LocalDate
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class PerformanceServiceTest {
    private val acquisitionRepository = mock(AcquisitionRepository::class.java)
    private val assetRepository = mock(AssetRepository::class.java)

    private val performanceService = PerformanceService(acquisitionRepository, assetRepository)

    @Test
    fun whenUserHasNoAssets_returnEmpty() {
        val userId = UUID.randomUUID()
        val asset1 = Asset(UUID.randomUUID(), "TEST1", 15.0)

        Mockito.`when`(assetRepository.findAll()).thenReturn(listOf(
            asset1,
        ))
        Mockito.`when`(acquisitionRepository.findByUserIdAndSellDate(userId, null)).thenReturn(listOf(
        ))

        val performance = performanceService.getPerformance(userId)

        assertEquals(0, performance.size)
    }

    @Test
    fun whenUserAcquiredMultipleAssets_returnProfitGroupedByTicker() {
        val userId = UUID.randomUUID()
        val asset1 = Asset(UUID.randomUUID(), "TEST1", 15.0)
        val asset2 = Asset(UUID.randomUUID(), "TEST2", 5.0)

        Mockito.`when`(assetRepository.findAll()).thenReturn(listOf(
            asset1,
            asset2,
        ))
        Mockito.`when`(acquisitionRepository.findByUserIdAndSellDate(userId, null)).thenReturn(listOf(
            Acquisition(UUID.randomUUID(), userId, asset1.id as UUID, 5.0, 10, LocalDate.now(), null),
            Acquisition(UUID.randomUUID(), userId, asset1.id as UUID, 10.0, 10, LocalDate.now(), null),
            Acquisition(UUID.randomUUID(), userId, asset2.id as UUID, 10.0, 10, LocalDate.now(), null),
        ))

        val performance = performanceService.getPerformance(userId)

        assertEquals(150.0, performance[asset1.ticker])
        assertEquals(-50.0, performance[asset2.ticker])
    }

}