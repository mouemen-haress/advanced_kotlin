package com.example.twowaydemo1.ui.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twowaydemo1.R
import com.example.twowaydemo1.adapters.NewsAdapter
import com.example.twowaydemo1.ui.NewsActivity
import com.example.twowaydemo1.ui.NewsViewModel
import com.example.twowaydemo1.utils.Contants.Companion.QUERY_PAGE_SIZE
import com.example.twowaydemo1.utils.Resource

class BrakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var recyclerList: RecyclerView
    lateinit var progressBar: ProgressBar

    var isLoading = false
    var isLastPage = false
    var isScroling = false

    private val TAG = "BrakingNewsFragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        recyclerList = view.findViewById(R.id.rvBreakingNews)
        progressBar = view.findViewById(R.id.paginationProgressBar)
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_brakingNewsFragment_to_articleFragment, bundle
            )
        }

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Sucess -> {
                    hideProgressBar()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles.toList())
                        val totalePages = it.totalResults/ QUERY_PAGE_SIZE+2
                        isLastPage = viewModel.breakingNewsPage == totalePages
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Log.e(TAG, it)
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        isLoading = true

    }

    private fun setupRecyclerView() {
        val scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScroling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                var layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount

                val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
                val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
                val isNotAtBeginning = firstVisibleItemPosition >= 0
                val isTotalMoreThanVisible = totalItemCount >= QUERY_PAGE_SIZE
                val shouldPaginate =
                    isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning && isTotalMoreThanVisible && isScroling
                if (shouldPaginate) {
                    viewModel.getBreakingNews("us")
                    isScroling = false
                }else{
                    recyclerView.setPadding(0,0,0,0)
                }
            }
        }

        newsAdapter = NewsAdapter()
        recyclerList.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(scrollListener)
        }


    }
}