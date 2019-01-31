package com.learning.invocegenerator.repository

import com.learning.invocegenerator.models.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, String>{
}