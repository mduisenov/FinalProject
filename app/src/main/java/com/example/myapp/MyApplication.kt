package com.example.myapp

import android.app.Application
import com.example.myapp.data.db.AppDatabase
import com.example.myapp.data.db.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication: Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { BookRepository(database.bookDao()) }

}