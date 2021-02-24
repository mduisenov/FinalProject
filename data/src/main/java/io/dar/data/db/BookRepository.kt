package io.dar.data.db

import io.dar.data.BookModel
import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookDao: BookDao) {

    val allBooks: Flow<List<BookModel>> = bookDao.getAll()



}