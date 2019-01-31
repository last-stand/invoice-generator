package com.learning.invocegenerator.controller

import com.learning.invocegenerator.repository.InvoiceItemRepository
import com.learning.invocegenerator.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/invoice")
class InvoiceController{

    @Autowired
    lateinit var invoiceItemRepository: InvoiceItemRepository

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @GetMapping("/")
    fun getAllInvoices() =
            invoiceRepository.findAll()

    @GetMapping("/{id}")
    fun getInvoiceById(@PathVariable id: Int) =
            invoiceRepository.findById(id)
}
