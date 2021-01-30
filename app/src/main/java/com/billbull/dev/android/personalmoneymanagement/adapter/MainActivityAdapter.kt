package com.billbull.dev.android.personalmoneymanagement.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.billbull.dev.android.personalmoneymanagement.databinding.ItemListBinding
import com.billbull.dev.android.personalmoneymanagement.db.entity.UangMasuk

class MainActivityAdapter(private val dataList: List<UangMasuk>, private val listener: (UangMasuk) -> Unit)
    : RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {

    private lateinit var binding: ItemListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        binding = ItemListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        with(holder) {
            with(dataList[position]) {
                binding.terimaDari.text = terima_dari
                binding.keterangan.text = keterangan
                binding.jumlah.text = jumlah.toString()

                itemView.setOnClickListener { listener(this) }
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class MainActivityViewHolder(binding: ItemListBinding): RecyclerView.ViewHolder(binding.root)

}