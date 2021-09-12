package com.jus10.portfoliomanager.service

import com.jus10.portfoliomanager.model.Asset
import com.jus10.portfoliomanager.model.api.AssetCreationDTO
import com.jus10.portfoliomanager.model.api.AssetDTO
import com.jus10.portfoliomanager.model.api.toAsset
import com.jus10.portfoliomanager.model.toAssetDTO
import com.jus10.portfoliomanager.repository.AssetRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AssetService(
    val assetRepository: AssetRepository,
) {
    fun findAll(): List<AssetDTO> = assetRepository.findAll().map { it.toAssetDTO(it.id as UUID) }
    fun findById(id: UUID): Asset = assetRepository.findById(id).orElseThrow()
    fun save(asset: AssetCreationDTO) = assetRepository.save(asset.toAsset())
}
