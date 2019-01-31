package com.learning.invocegenerator.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "order")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var iddd: Int = 0,

    val bill: String,

    val date: LocalDateTime = LocalDateTime.now()
)