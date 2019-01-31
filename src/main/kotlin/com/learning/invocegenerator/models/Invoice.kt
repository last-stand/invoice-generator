package com.learning.invocegenerator.models

import javax.persistence.*

@Entity
@Table(name = "invoice")
class Invoice (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @OneToOne
    val content: Content,

    @OneToOne
    val product: Product,

    val quantity: Int
)