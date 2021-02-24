package com.example.myapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.myapp.R
import com.example.myapp.data.Book

class BookListAdapter: ListAdapter<Book, BookListAdapter.BookViewHolder>(BOOKS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val bookItemView: TextView = itemView.findViewById(R.id.book_name_text_view)

        fun bind(bookName: String) {
            bookItemView.text = bookName
        }

        companion object {
            fun create(parent: ViewGroup): BookViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.book_item, parent, false)
                return BookViewHolder(view)
            }
        }

    }

    companion object {
        private val BOOKS_COMPARATOR = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}


