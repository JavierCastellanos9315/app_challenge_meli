package com.example.app_challenge_meli.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.app_challenge_meli.adapters.ProductsAdapter
import com.example.app_challenge_meli.databinding.ActivityMainBinding
import com.example.app_challenge_meli.isNetworkAvailable
import com.example.app_challenge_meli.viewmodels.ProductViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val productViewModel: ProductViewModel by viewModels()

    private val adapter = ProductsAdapter {
        productViewModel.onProductClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(btnSearch)

        binding.edtSearch.setOnEditorActionListener(edtSearchListener)

        productViewModel.state.observe(this){ state ->
            binding.progress.visibility = if (state.loading) View.VISIBLE else View.GONE
            state.products?.let {
                adapter.products = it
                adapter.notifyDataSetChanged()
                if(adapter.products.isEmpty()){
                    binding.cardMsg.visibility = View.VISIBLE
                    binding.recycler.visibility = View.GONE
                } else {
                    binding.recycler.visibility = View.VISIBLE
                    binding.cardMsg.visibility = View.GONE
                }
            }
            state.navigateTo?.let {
                val intent : Intent = Intent (this, DetailActivity::class.java).apply {
                    putExtra("ID",it.id)
                }
                startActivity(intent)
            }
        }


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
        binding.button.isEnabled = false
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        if(isNetworkAvailable(this)){
            productViewModel.getProducts(binding.edtSearch.text.toString())
            binding.recycler.adapter = adapter
        } else {
            Toast.makeText(applicationContext,"this is toast message", Toast.LENGTH_SHORT).show()
        }
        binding.button.isEnabled = true
        FirebaseCrashlytics.getInstance().checkForUnsentReports()

    }


}