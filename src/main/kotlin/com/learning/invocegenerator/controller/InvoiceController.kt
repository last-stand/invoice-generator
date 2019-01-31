package com.learning.invocegenerator.controller

import com.learning.invocegenerator.repository.InvoiceItemRepository
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

    @GetMapping("/")
    fun getAllInvoices() =
            invoiceItemRepository.findAll()

    @GetMapping("/{id}")
    fun getInvoiceById(@PathVariable id: Int) =
            invoiceItemRepository.findByInvoiceId(id)
}