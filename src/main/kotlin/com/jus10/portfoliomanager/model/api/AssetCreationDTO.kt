package com.jus10.portfoliomanager.model.api

import com.jus10.portfoliomanager.model.Asset

data class AssetCreationDTO(
    val ticker: String,
    val price: Double,
)

fun AssetCreationDTO.toAsset() = Asset(ticker, price)
