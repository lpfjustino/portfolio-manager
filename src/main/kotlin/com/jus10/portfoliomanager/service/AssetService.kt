package com.jus10.portfoliomanager.service

import com.jus10.portfoliomanager.model.api.AssetDTO
import com.jus10.portfoliomanager.model.api.toAsset
import com.jus10.portfoliomanager.model.toAssetDTO
import com.jus10.portfoliomanager.repository.AssetRepository
import exception.DBException
import exception.ResourceAlreadyExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.relational.core.conversion.DbActionExecutionException
import org.springframework.stereotype.Service
import java.rmi.AlreadyBoundException
import java.sql.SQLException

@Service
class AssetService {
    @Autowired
    lateinit var assetRepository: AssetRepository

    fun findAll(): List<AssetDTO> = assetRepository.findAll().map { it.toAssetDTO() }
    fun save(asset: AssetDTO) {
        try {
            assetRepository.save(asset.toAsset())
        } catch (e: DbActionExecutionException) {
            throw ResourceAlreadyExistsException("An asset with such ticker already exists")
        }
    }
}