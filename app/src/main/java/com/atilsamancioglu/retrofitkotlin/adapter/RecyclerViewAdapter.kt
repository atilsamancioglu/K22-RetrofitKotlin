package com.atilsamancioglu.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atilsamancioglu.retrofitkotlin.databinding.RowLayoutBinding
import com.atilsamancioglu.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList: ArrayList<CryptoModel>, private val listener: Listener) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private val colors: Array<String> =
        arrayOf("#13bd27", "#29c1e1", "#b129e1", "#d3df13", "#f6bd0c", "#a1fb93", "#0d9de3", "#ffe48f")

    class RowHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener: Listener) {

            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            binding.textName.text = cryptoModel.currency
            binding.textPrice.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], colors, position, listener)
    }


}