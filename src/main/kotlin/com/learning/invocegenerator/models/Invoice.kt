package com.learning.invocegenerator.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "invoice")
data class Invoice(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    val billTo: String,

    val date: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"))

)