package com.jus10.portfoliomanager.repository

import com.jus10.portfoliomanager.model.Acquisition
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface AcquisitionRepository : PagingAndSortingRepository<Acquisition, UUID> {
    fun findByUserId(userId: UUID): List<Acquisition>
}
