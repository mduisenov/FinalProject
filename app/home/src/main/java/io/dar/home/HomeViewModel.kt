package io.dar.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import io.dar.data.BookModel

class HomeViewModel(private val repository: io.dar.data.db.BookRepository) : ViewModel() {

    val allBooks: LiveData<List<BookModel>> = repository.allBooks.asLiveData()

}

class HomeViewModelFactory(private val repository: io.dar.data.db.BookRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}