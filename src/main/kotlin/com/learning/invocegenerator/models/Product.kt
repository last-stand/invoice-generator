package com.learning.invocegenerator.models

import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    val name: String,

    val unitPrice: Double
)
