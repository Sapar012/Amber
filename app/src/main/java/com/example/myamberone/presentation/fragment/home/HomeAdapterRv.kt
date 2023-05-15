package com.example.myamberone.presentation.fragment.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myamberone.databinding.ItemMainRvBinding
import com.example.myamberone.presentation.model.HitUI

class HomeAdapterRv : RecyclerView.Adapter<HomeAdapterRv.HomeViewHolder>() {

    private var list: ArrayList<HitUI> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<HitUI>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemMainRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class HomeViewHolder(private val binding: ItemMainRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HitUI) {
            binding.itemTvItemTitleRv.text = model.titleProduct
            binding.itemTvPriceRv.text = model.price.toString()
            Glide.with(binding.itemImgRv)
                .load(model.imageProduct)
                .into(binding.itemImgRv)
        }
    }
}
