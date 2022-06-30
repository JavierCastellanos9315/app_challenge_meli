package com.example.app_challenge_meli.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.app_challenge_meli.adapters.CaracteristicasAdapter
import com.example.app_challenge_meli.convertPrice
import com.example.app_challenge_meli.databinding.ActivityDetailBinding
import com.example.app_challenge_meli.isNetworkAvailable
import com.example.app_challenge_meli.loadUrl
import com.example.app_challenge_meli.viewmodels.DetailViewModel
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    private val adapter = CaracteristicasAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(isNetworkAvailable(this)){
            detailViewModel.onCreate(intent.getStringExtra("ID"))
            detailViewModel.getDescription(intent.getStringExtra("ID"))
            binding.recyclerCaracteristicas.adapter = adapter

            detailViewModel.state.observe(this){state ->
                with(binding) {
                    progress.visibility = if (state.loading) View.VISIBLE else View.GONE
                    lyMain.visibility = if (!state.loading) View.VISIBLE else View.GONE

                    state.item?.attributes?.let {
                        adapter.attributes = it
                        adapter.notifyDataSetChanged()
                    }
                    state?.item?.pictures?.get(0)?.secureUrl?.let { thumb.loadUrl(it) }
                    state?.item?.price?.let { txtPrecio.text = convertPrice(it) }
                    state?.description?.plainText?.let { txtDescripcionProd.text = it }
                }
            }
        } else {
            Toast.makeText(applicationContext,"this is toast message", Toast.LENGTH_SHORT).show()
        }
        binding.imgAtras.setOnClickListener { finish() }
    }
}