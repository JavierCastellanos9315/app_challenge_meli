package com.example.app_challenge_meli.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_challenge_meli.R
import com.example.app_challenge_meli.convertPrice
import com.example.app_challenge_meli.databinding.ViewProductBinding
import com.example.app_challenge_meli.inflate
import com.example.app_challenge_meli.loadUrl
import com.example.app_challenge_meli.model.search.Producto

class ProductsAdapter (var products: List<Producto> = emptyList(), private val listener: (Producto) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_product, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.setOnClickListener { listener(product) }
    }

    override fun getItemCount(): Int = products.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewProductBinding.bind(view)
        fun bind(product: Producto) {
            binding.title.text = product.title
            product.thumbnail?.let { binding.thumb.loadUrl(it) }
            binding.txtPrice.text = product.price?.let { convertPrice(it.toDouble()) }
            //binding.favorite.setImageResource(if (product.favorite) R.drawable.ic_favorite else 0)
        }
    }

}