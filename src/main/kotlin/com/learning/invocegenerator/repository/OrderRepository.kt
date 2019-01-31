package com.learning.invocegenerator.repository

import com.learning.invocegenerator.models.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: CrudRepository<Order, Int> {
}