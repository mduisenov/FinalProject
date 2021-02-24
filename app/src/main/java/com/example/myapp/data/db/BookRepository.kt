package com.example.myapp.data.db

import com.example.myapp.data.Book
import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookDao: BookDao) {

    val allBooks: Flow<List<Book>> = bookDao.getAll()



}