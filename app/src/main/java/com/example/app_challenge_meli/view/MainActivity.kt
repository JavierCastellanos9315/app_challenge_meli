package com.example.app_challenge_meli.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.app_challenge_meli.PARAMETRO_ID
import com.example.app_challenge_meli.R
import com.example.app_challenge_meli.adapters.ProductsAdapter
import com.example.app_challenge_meli.databinding.ActivityMainBinding
import com.example.app_challenge_meli.isNetworkAvailable
import com.example.app_challenge_meli.viewmodels.ProductViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val productViewModel: ProductViewModel by viewModels()

    private var isFirstTime : Boolean = true

    private val adapter = ProductsAdapter {
        productViewModel.onProductClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(btnSearch)

        binding.edtSearch.setOnEditorActionListener(edtSearchListener)
        binding.lyMensajeError.btnRefresh.setOnClickListener(btnSearch)
        configObServable()
        FirebaseCrashlytics.getInstance().checkForUnsentReports()
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

    override fun onResume() {
        super.onResume()
        productViewModel.setNavigateTo()
    }

    /**
     * Escuchador cuando de accion de buscar
     **/
    val edtSearchListener = TextView.OnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            binding.button.callOnClick()
            return@OnEditorActionListener true
        }
        false
    }

    /**
     * Llama al viewModel para obtener datos de los productos relacionados a la busqueda
     **/
    val btnSearch =  View.OnClickListener{ v->
        isFirstTime = false
        binding.button.isEnabled = false
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        if(isNetworkAvailable(this)){
            productViewModel.getProducts(binding.edtSearch.text.toString())
            binding.recycler.adapter = adapter
        } else {
            binding.recycler.visibility = View.GONE
            binding.lyMensajeError.root.visibility =  View.VISIBLE

            setMessageError(true,
                getString(R.string.error_internet),
                getString(R.string.titulo_error_internet),
                R.drawable.signal_off)
        }
        binding.button.isEnabled = true
    }

    /**
     * Se configura el observador
     **/
    fun configObServable (){
        productViewModel.state.observe(this){ state ->
            binding.progress.visibility = if (state.loading) View.VISIBLE else View.GONE
            state.products?.let {
                adapter.products = state.products
                adapter.notifyDataSetChanged()
                if (adapter.products.isEmpty() && state.isSuccess) {
                    binding.recycler.visibility = View.GONE
                    binding.lyMensajeError.root.visibility = View.VISIBLE
                    setMessageError(
                        false,
                        getString(R.string.empty_search),
                        getString(R.string.titulo_lo_sentimos),
                        R.drawable.ic_search_off
                    )
                } else if (state.isSuccess) {
                    binding.recycler.visibility = View.VISIBLE
                    binding.lyMensajeError.root.visibility = View.GONE
                } else {
                    binding.recycler.visibility = View.GONE
                    binding.lyMensajeError.root.visibility = View.VISIBLE
                    setMessageError(
                        true,
                        getString(R.string.error_service),
                        getString(R.string.titulo_lo_sentimos),
                        R.drawable.error_service
                    )
                }
            }
            if(state.products == null && !state.isSuccess && !isFirstTime){
                binding.recycler.visibility = View.GONE
                binding.lyMensajeError.root.visibility = View.VISIBLE
                setMessageError(
                    true,
                    getString(R.string.error_service),
                    getString(R.string.titulo_lo_sentimos),
                    R.drawable.error_service
                )
            }
            if(isFirstTime){
                binding.recycler.visibility = View.VISIBLE
                binding.lyMensajeError.root.visibility = View.GONE
            }

            state.navigateTo?.let {
                val intent : Intent = Intent (this, DetailActivity::class.java).apply {
                    putExtra(PARAMETRO_ID,it.id)
                }
                startActivity(intent)
            }
        }
    }

}