package com.example.myapp.data.db

import androidx.room.*
import com.example.myapp.data.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getAll(): Flow<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg books: Book)

    @Query("DELETE FROM books")
    suspend fun deleteAll()

}