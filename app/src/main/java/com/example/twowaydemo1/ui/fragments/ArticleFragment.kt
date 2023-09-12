package com.example.twowaydemo1.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material3.Snackbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.twowaydemo1.R
import com.example.twowaydemo1.models.Article
import com.example.twowaydemo1.ui.NewsActivity
import com.example.twowaydemo1.ui.NewsViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    lateinit var webView: WebView
    lateinit var floatingBtn: FloatingActionButton

    val args: ArticleFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        webView = view.findViewById(R.id.webView)
        floatingBtn = view.findViewById(R.id.fab)

        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        floatingBtn.setOnClickListener {
            viewModel.saveArticle(article = article)
            com.google.android.material.snackbar.Snackbar.make(
                view,
                "saved successfuly",
                Snackbar.LENGTH_SHORT

            ).show()
        }

    }


}