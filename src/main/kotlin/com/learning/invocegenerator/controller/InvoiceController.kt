package com.learning.invocegenerator.controller

import com.learning.invocegenerator.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoice")
class InvoiceController{

    @Autowired
    lateinit var orderRepository: OrderRepository

    @GetMapping("/")
    fun getAllOrders() =
            orderRepository.findAll()
}