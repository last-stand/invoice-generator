package com.learning.invocegenerator.repository

import com.learning.invocegenerator.models.InvoiceItem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceItemRepository: CrudRepository<InvoiceItem, Int> {
}
