package com.learning.invocegenerator

import com.learning.invocegenerator.models.Invoice
import com.learning.invocegenerator.models.InvoiceItem
import com.learning.invocegenerator.models.Product
import com.learning.invocegenerator.repository.InvoiceItemRepository
import com.learning.invocegenerator.repository.InvoiceRepository
import com.learning.invocegenerator.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class InvoceGeneratorApplication {

    @Bean
    fun databaseInitlizer(invoiceItemRepository: InvoiceItemRepository,
                          productRepository: ProductRepository,
                          invoiceRepository: InvoiceRepository) = CommandLineRunner {

        val butter = Product( name= "Butter", unitPrice = 20.0)
        val knife = Product(name= "Knife", unitPrice= 30.0)
        val milk = Product(name= "Milk", unitPrice= 26.50)
        productRepository.save(butter)
        productRepository.save(knife)
        productRepository.save(milk)

        val invoiceItem1 = InvoiceItem(product = butter, quantity = 5)
        val invoiceItem2 = InvoiceItem(product = knife, quantity = 1)
        val invoiceItem3 = InvoiceItem(product = milk, quantity = 2)
        val invoiceItem4 = InvoiceItem(product = milk, quantity = 8)

        val invoice1 = Invoice(customer = "Me", invoiceItem = setOf(invoiceItem1, invoiceItem2, invoiceItem3))
        val invoice2 = Invoice(customer = "You", invoiceItem = setOf(invoiceItem4))

        invoiceRepository.save(invoice1)
        invoiceRepository.save(invoice2)

        invoiceItemRepository.save(invoiceItem1)
        invoiceItemRepository.save(invoiceItem2)
        invoiceItemRepository.save(invoiceItem3)
        invoiceItemRepository.save(invoiceItem4)
    }
}

fun main(args: Array<String>) {
    runApplication<InvoceGeneratorApplication>(*args)
}
