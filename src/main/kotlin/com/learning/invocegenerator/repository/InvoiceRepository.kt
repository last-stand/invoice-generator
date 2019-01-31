package com.learning.invocegenerator.repository

import com.learning.invocegenerator.models.Invoice
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository: CrudRepository<Invoice, Int> {
}