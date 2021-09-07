package com.jus10.portfoliomanager.repository

import com.jus10.portfoliomanager.model.Asset
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AssetRepository : CrudRepository<Asset, Long>
