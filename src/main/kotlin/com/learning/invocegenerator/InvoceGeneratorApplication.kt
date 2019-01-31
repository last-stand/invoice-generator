package com.learning.invocegenerator

import com.learning.invocegenerator.models.Content
import com.learning.invocegenerator.models.Invoice
import com.learning.invocegenerator.models.Product
import com.learning.invocegenerator.repository.ContentRepository
import com.learning.invocegenerator.repository.InvoiceRepository
import com.learning.invocegenerator.repository.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class InvoceGeneratorApplication {

    @Bean
    fun databaseInitlizer(invoiceRepository: InvoiceRepository,
                          productRepository: ProductRepository,
                          contentRepository: ContentRepository) = CommandLineRunner {

        val butter = Product( name= "Butter", unitPrice = 20.0)
        val knife = Product(name= "Knife", unitPrice= 30.0)
        val milk = Product(name= "Milk", unitPrice= 26.50)

        val content = Content(billTo = "Me")

        val invoice1 = Invoice(product = butter, quantity = 5, content = content)
        val invoice2 = Invoice(product = knife, quantity = 1, content = content)
        val invoice3 = Invoice(product = milk, quantity = 2, content = content)

        productRepository.save(butter)
        productRepository.save(knife)
        productRepository.save(milk)

        contentRepository.save(content)

        invoiceRepository.save(invoice1)
        invoiceRepository.save(invoice2)
        invoiceRepository.save(invoice3)
    }
}

fun main(args: Array<String>) {
    runApplication<InvoceGeneratorApplication>(*args)
}

