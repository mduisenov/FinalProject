package com.example.myapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.MyApplication
import com.example.myapp.R
import com.example.myapp.ui.home.adapter.BookListAdapter

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVm()

        val bookRecyclerView = view.findViewById<RecyclerView>(R.id.book_recycler_view)
        val bookAdapter = BookListAdapter()
        bookRecyclerView?.adapter = bookAdapter
        bookRecyclerView?.layoutManager = LinearLayoutManager(activity)

        viewModel.allBooks.observe(viewLifecycleOwner) {
            it.let { bookAdapter.submitList(it) }
        }

    }

    private fun initVm() {
        val app = requireActivity().application as MyApplication
        val repository = app.repository
        val factory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)
                .get(HomeViewModel::class.java)
    }

}