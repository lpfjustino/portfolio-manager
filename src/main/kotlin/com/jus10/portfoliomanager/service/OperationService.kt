package com.jus10.portfoliomanager.service

import com.jus10.portfoliomanager.model.api.AcquisitionDTO
import com.jus10.portfoliomanager.model.api.toAcquisition
import com.jus10.portfoliomanager.repository.AcquisitionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class OperationService {

    @Autowired
    lateinit var assetService: AssetService
    @Autowired
    lateinit var acquisitionRepository: AcquisitionRepository

    fun buy(acquisition: AcquisitionDTO) {
        val asset = assetService.findById(acquisition.assetId)
        acquisitionRepository.save(acquisition.toAcquisition(asset.price, LocalDate.now(), null))
    }
}