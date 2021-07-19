package com.dicoding.schoolapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.schoolapp.R
import com.dicoding.schoolapp.core.domain.model.Schoolism
import com.dicoding.schoolapp.databinding.ItemListTourismBinding
import java.util.ArrayList

class SchoolAdapter : RecyclerView.Adapter<SchoolAdapter.ListViewHolder>() {

    private var listData = ArrayList<Schoolism>()
    var onItemClick: ((Schoolism) -> Unit)? = null

    fun setData(newListData: List<Schoolism>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tourism, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTourismBinding.bind(itemView)
        fun bind(data: Schoolism) {
            with(binding) {

                tvItemTitle.text = data.sekolah
                tvItemSubtitle.text = data.status

            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}