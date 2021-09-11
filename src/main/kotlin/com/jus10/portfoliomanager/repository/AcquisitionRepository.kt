package com.jus10.portfoliomanager.repository

import com.jus10.portfoliomanager.model.Acquisition
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AcquisitionRepository : CrudRepository<Acquisition, UUID>
