package com.jus10.portfoliomanager.model.api

import com.jus10.portfoliomanager.model.Acquisition
import java.time.LocalDate
import java.util.*

data class AcquisitionDTO(
    val userId: UUID,
    val assetId: UUID,
    val quantity: Int,
)

fun AcquisitionDTO.toAcquisition(price: Double, acquisitionDate: LocalDate, sellDate: LocalDate?) =
    Acquisition(null, userId, assetId, price, quantity, acquisitionDate, sellDate)
