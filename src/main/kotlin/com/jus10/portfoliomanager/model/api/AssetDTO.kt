package com.jus10.portfoliomanager.model.api

import com.jus10.portfoliomanager.model.Asset
import java.util.*

data class AssetDTO(
    val id: UUID,
    val ticker: String,
    val price: Double,
)

fun AssetDTO.toAsset() = Asset(ticker, price)
