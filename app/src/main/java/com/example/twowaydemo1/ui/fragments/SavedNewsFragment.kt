package com.example.twowaydemo1.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twowaydemo1.R
import com.example.twowaydemo1.adapters.NewsAdapter
import com.example.twowaydemo1.ui.NewsActivity
import com.example.twowaydemo1.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import java.util.Objects

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    lateinit var viewModel: NewsViewModel

    lateinit var newsAdapter: NewsAdapter
    lateinit var recyclerList: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        recyclerList = view.findViewById(R.id.rvSavedNews)
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_searchNewsFragment_to_articleFragment, bundle
            )
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT

        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true;
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                viewModel.deleteArticle(article = article)


                com.google.android.material.snackbar.Snackbar.make(
                    view,
                    "deleted successfuly",
                    Snackbar.LENGTH_SHORT
                ).apply {
                    setAction("Undo") {
                        viewModel.saveArticle(article = article)
                    }
                    show()
                }
            }
        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(recyclerList)
        }

        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer {
            newsAdapter.differ.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        recyclerList.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}