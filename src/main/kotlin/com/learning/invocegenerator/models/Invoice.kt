package com.learning.invocegenerator.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "invoice")
data class Invoice(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    val customer: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "invoice_item_id")
    val invoiceItem: Set<InvoiceItem>,

    val date: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"))

)