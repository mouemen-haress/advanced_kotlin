package com.example.twowaydemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.twowaydemo1.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mRetService: AlbumService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mRetService = RetrofitClient.getRetrofitClient().create(AlbumService::class.java)

//        getResponseFromUrlWithQueryParams()
//        getResponseFromUrlWithParams();

        uploadAlbum(AlbumsItem(101, "helo", 101))
    }

    private fun uploadAlbum(album: AlbumsItem) {
        val responseLiveData: LiveData<Response<AlbumsItem>> = liveData {
            val response = mRetService.uploadAlbum(album)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val album = it.body()
            mBinding.text.append(album?.title)
        })
    }

    private fun getResponseFromUrlWithQueryParams() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = mRetService.getSortedAlbumes(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = " Album title  : ${albumsItem.title} \n \n \n "
                    mBinding.text.append(result)
                }
            }
        })
    }

    private fun getResponseFromUrlWithParams() {
        // get just one Album using to test the implementstion of Api like
        // https://jsonplaceholder.typicode.com/albums/3
        val responseLiveData: LiveData<Response<AlbumsItem>> = liveData {
            val response = mRetService.getSortedAlbum(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumItem = it.body()
            mBinding.text.append(albumItem?.title)
        })
    }
}
