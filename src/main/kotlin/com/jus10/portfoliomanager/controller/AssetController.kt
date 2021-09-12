package com.jus10.portfoliomanager.controller

import com.jus10.portfoliomanager.model.api.AssetCreationDTO
import com.jus10.portfoliomanager.service.AssetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assets")
class AssetController(
    val assetService: AssetService
) {
    @GetMapping
    fun findAll() = assetService.findAll()

    @PostMapping
    fun create(@RequestBody asset: AssetCreationDTO) = assetService.save(asset)
}
