package com.learning.invocegenerator.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.learning.invocegenerator.models.Content

@Repository
interface ContentRepository : CrudRepository<Content, Int> {
}