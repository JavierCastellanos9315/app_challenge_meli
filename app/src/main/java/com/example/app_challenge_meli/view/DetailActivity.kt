package com.example.app_challenge_meli.view

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.app_challenge_meli.*
import com.example.app_challenge_meli.adapters.CaracteristicasAdapter
import com.example.app_challenge_meli.databinding.ActivityDetailBinding
import com.example.app_challenge_meli.viewmodels.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    private val adapter = CaracteristicasAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lyMensajeError.btnRefresh.setOnClickListener(btnSearch)
        getInfoItem()
        binding.imgAtras.setOnClickListener { finish() }
    }

    private fun configObserver() {
        detailViewModel.state.observe(this) { state ->
            with(binding) {
                if(state.loading){
                    lyMain.visibility = View.GONE
                    centerMainLayout(true)
                    progress.visibility = View.VISIBLE
                } else {
                    centerMainLayout(false)
                    progress.visibility = View.GONE
                    lyMain.visibility = View.VISIBLE
                }

                if(state.item != null && state.description != null){
                    state.item?.attributes?.let {
                        adapter.attributes = it
                        adapter.notifyDataSetChanged()
                    }
                    state?.item?.pictures?.get(0)?.secureUrl?.let { thumb.loadUrl(it) }
                    state?.item?.price?.let { txtPrecio.text = convertPrice(it) }
                    state?.description?.plainText?.let { txtDescripcionProd.text = it }
                } else {//if ((state.item != null && !state.isSuccess)|| (state.description != null && !state.isSuccess) ){
                    binding.lyMain.visibility = View.GONE
                    binding.lyMensajeError.root.visibility = View.VISIBLE
                    centerMainLayout(true)
                    setMessageError(
                        true,
                        getString(R.string.error_service),
                        getString(R.string.titulo_lo_sentimos),
                        R.drawable.error_service
                    )
                }
            }
        }
    }

    private fun centerMainLayout(isCenter: Boolean) {
        val params = binding.lyMainScroll.getLayoutParams() as FrameLayout.LayoutParams
        params.gravity = if (isCenter) Gravity.CENTER else -1
        binding.lyMainScroll.setLayoutParams(params)
    }

    /**
     * Cambia el mensaje de error a mostrar
     **/
    fun setMessageError(isVisibleButton : Boolean, text : String,titulo : String, imgResource : Int ){
        binding.lyMensajeError.lyButtonActualizar.visibility = if (isVisibleButton) View.VISIBLE else View.GONE
        binding.lyMensajeError.txtTituloAlerta.text = titulo
        binding.lyMensajeError.txtMensajeAlerta.text = text
        binding.lyMensajeError.imgAlerta.setImageResource(imgResource)
    }

    fun getInfoItem(){
        if(isNetworkAvailable(this)){
            detailViewModel.getData(intent.getStringExtra(PARAMETRO_ID))
            binding.recyclerCaracteristicas.adapter = adapter
            configObserver()
        } else {
            binding.lyMain.visibility = View.GONE
            binding.lyMensajeError.root.visibility = View.VISIBLE
            centerMainLayout(true)
            setMessageError(true,
                getString(R.string.error_internet),
                getString(R.string.titulo_error_internet),
                R.drawable.signal_off)
        }
    }


    val btnSearch =  View.OnClickListener { v ->
        getInfoItem()
    }
}