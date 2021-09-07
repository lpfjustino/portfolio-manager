package com.jus10.portfoliomanager.model

import com.jus10.portfoliomanager.model.api.AssetDTO
import org.springframework.data.annotation.Id
import java.util.*

data class Asset(
    @Id val id: UUID?,
    val ticker: String,
    val price: Double,
)

fun Asset.toAssetDTO() = AssetDTO(
    ticker = ticker,
    price = price,
)
