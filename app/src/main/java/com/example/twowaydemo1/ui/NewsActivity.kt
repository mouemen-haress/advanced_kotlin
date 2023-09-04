package com.example.twowaydemo1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.twowaydemo1.*
import com.example.twowaydemo1.databinding.ActivityNewsBinding
import com.example.twowaydemo1.db.ArticleDataBase
import com.example.twowaydemo1.repository.NewsRepository
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityNewsBinding
    private lateinit var mHostFragment: NavController
    public lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = NewsRepository(ArticleDataBase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository = repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)
        mHostFragment = findNavController(R.id.newsNavHostFragment)
        mBinding.bottomNavigationView.setupWithNavController(mHostFragment)


    }

}
