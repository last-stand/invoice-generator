package com.learning.invocegenerator.models

import javax.persistence.*

@Entity
@Table(name = "invoice_item")
class InvoiceItem (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    val invoice: Invoice,

    @OneToOne
    val product: Product,

    val quantity: Int
)