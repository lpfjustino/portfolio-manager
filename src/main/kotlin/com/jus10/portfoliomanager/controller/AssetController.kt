package com.jus10.portfoliomanager.controller

import com.jus10.portfoliomanager.model.api.AssetDTO
import com.jus10.portfoliomanager.service.AssetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assets")
class AssetController {

    @Autowired
    lateinit var assetService: AssetService

    @GetMapping
    fun findAll() = assetService.findAll()

    @PostMapping
    fun create(@RequestBody asset: AssetDTO) = assetService.save(asset)
}