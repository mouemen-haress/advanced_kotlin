package com.example.twowaydemo1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.twowaydemo1.R
import com.example.twowaydemo1.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArtticleViewHolder>() {

    inner class ArtticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtticleViewHolder {
        return ArtticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ArtticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage)
                .into(findViewById(R.id.ivArticleImage))

            findViewById<TextView>(R.id.tvSource).text = article.source?.name
            findViewById<TextView>(R.id.tvTitle).text = article.title
            findViewById<TextView>(R.id.tvDescription).text = article.description
            findViewById<TextView>(R.id.tvPublishedAt).text = article.publishedAt

            setOnClickListener(View.OnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            })

        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}