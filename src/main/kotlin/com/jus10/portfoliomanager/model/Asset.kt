package com.jus10.portfoliomanager.model

import com.jus10.portfoliomanager.model.api.AssetDTO
import org.springframework.data.annotation.Id
import java.util.*

data class Asset(
    @Id val id: UUID?,
    val ticker: String,
    val price: Double,
) {
    constructor(ticker: String, price: Double) : this(null, ticker, price)
}

fun Asset.toAssetDTO(id: UUID) = AssetDTO(id, ticker, price)
