package com.learning.invocegenerator.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "content")
data class Content(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    val billTo: String,

    val date: LocalDateTime = LocalDateTime.now()
)