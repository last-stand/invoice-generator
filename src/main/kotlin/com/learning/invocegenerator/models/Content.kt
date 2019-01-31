package com.learning.invocegenerator.models

import javax.persistence.*

@Entity
@Table(name = "content")
class Content (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @ManyToOne
    val orders: Order,

    @ManyToOne
    val product: Product,

    val quantity: Int
)