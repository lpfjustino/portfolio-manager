package com.jus10.portfoliomanager.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.*

@Table("asset-acquisition")
data class Acquisition(
    @Id val id: UUID,
    val userId: UUID,
    val assetId: UUID,
    val price: Double,
    val quantity: Int,
    val acquisitionDate: LocalDate,
    val sellDate: LocalDate?,
) {
    constructor(
        userId: UUID,
        assetId: UUID,
        price: Double,
        quantity: Int,
        acquisitionDate: LocalDate,
        sellDate: LocalDate?,
    ) : this(
        UUID.randomUUID(),
        userId,
        assetId,
        price,
        quantity,
        acquisitionDate,
        sellDate
    )
}
