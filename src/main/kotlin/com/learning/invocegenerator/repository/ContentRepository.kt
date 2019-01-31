package com.learning.invocegenerator.repository

import com.learning.invocegenerator.models.Content
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentRepository : CrudRepository<Content, Int> {
}