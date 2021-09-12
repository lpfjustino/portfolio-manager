package com.jus10.portfoliomanager.service

import com.jus10.portfoliomanager.model.Acquisition
import com.jus10.portfoliomanager.model.Asset
import com.jus10.portfoliomanager.repository.AcquisitionRepository
import com.jus10.portfoliomanager.repository.AssetRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PerformanceService(
    val acquisitionRepository: AcquisitionRepository,
    val assetRepository: AssetRepository,
) {
    fun getPerformance(userId: UUID): Map<String, Double> {
        val assets: Map<UUID, Asset> = assetRepository.findAll()
            .associateBy { it.id as UUID }
        return acquisitionRepository.findByUserIdAndSellDate(userId, null)
            .groupingBy { it.assetId }
            .fold(listOf<Double>()) { acc, acquisition -> acc + getProfit(acquisition, assets) }
            .mapValues { it.value.reduce { acc, profit -> acc + profit } }
            .mapKeysTo(mutableMapOf()) { assets[it.key]!!.ticker }
    }

    fun getProfit(acquisition: Acquisition, assets: Map<UUID, Asset>) =
        (assets[acquisition.assetId]!!.price - acquisition.price) * acquisition.quantity
}