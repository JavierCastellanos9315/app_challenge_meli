package com.example.app_challenge_meli.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_challenge_meli.R
import com.example.app_challenge_meli.databinding.ViewCaracteristicaBinding
import com.example.app_challenge_meli.inflate
import com.example.app_challenge_meli.model.item.Attribute

class CaracteristicasAdapter(var attributes: List<Attribute> = emptyList()) :
    RecyclerView.Adapter<CaracteristicasAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_caracteristica, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attribute = attributes[position]
        holder.bind(attribute)
    }

    override fun getItemCount(): Int = attributes.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewCaracteristicaBinding.bind(view)
        fun bind(attribute: Attribute) {
            binding.txtNameCaracteristica.text = attribute.name
            binding.txtNameValueCaracteristica.text = attribute.valueName
        }
    }
}