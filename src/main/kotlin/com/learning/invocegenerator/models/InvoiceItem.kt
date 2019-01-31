package com.learning.invocegenerator.models

import javax.persistence.*

@Entity
@Table(name = "invoice_item")
class InvoiceItem (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @OneToOne
    val product: Product,

    val quantity: Int
)
