package com.jus10.portfoliomanager.controller

import com.jus10.portfoliomanager.model.api.AcquisitionDTO
import com.jus10.portfoliomanager.service.OperationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/operations")
class OperationController(
    val operationService: OperationService
) {
    @PostMapping("/acquire")
    fun acquire(@RequestBody acquisition: AcquisitionDTO) = operationService.buy(acquisition)
}