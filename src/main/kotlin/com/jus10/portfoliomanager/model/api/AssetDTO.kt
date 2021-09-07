package com.jus10.portfoliomanager.model.api

import com.jus10.portfoliomanager.model.Asset

data class AssetDTO(
    val ticker: String,
    val price: Double,
)

fun AssetDTO.toAsset() = Asset(
    id = null,
    ticker = ticker,
    price = price,
)
