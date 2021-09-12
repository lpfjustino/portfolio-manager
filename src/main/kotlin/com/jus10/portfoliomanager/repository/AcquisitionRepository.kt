package com.jus10.portfoliomanager.repository

import com.jus10.portfoliomanager.model.Acquisition
import org.springframework.data.repository.PagingAndSortingRepository
import java.time.LocalDate
import java.util.*

interface AcquisitionRepository : PagingAndSortingRepository<Acquisition, UUID> {
    fun findByUserId(userId: UUID): List<Acquisition>
    fun findByUserIdAndSellDate(userId: UUID, sellDate: LocalDate?): List<Acquisition>
}
