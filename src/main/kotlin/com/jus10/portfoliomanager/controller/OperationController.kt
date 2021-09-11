package com.jus10.portfoliomanager.controller

import com.jus10.portfoliomanager.model.api.AcquisitionDTO
import com.jus10.portfoliomanager.model.api.AssetDTO
import com.jus10.portfoliomanager.service.AssetService
import com.jus10.portfoliomanager.service.OperationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/operations")
class OperationController {

    @Autowired
    lateinit var operationService: OperationService

    @PostMapping("/acquire")
    fun acquire(@RequestBody acquisition: AcquisitionDTO) = operationService.buy(acquisition)
}