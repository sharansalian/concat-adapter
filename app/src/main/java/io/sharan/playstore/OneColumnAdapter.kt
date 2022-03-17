package io.sharan.playstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.sharan.playstore.databinding.ViewOneColumnBinding

class OneColumnAdapter(
    private val onClick: (String) -> Unit
) : ListAdapter<String, OneColumnViewHolder>(StringDiffCallback) {

    companion object {
        const val VIEW_TYPE = 111
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneColumnViewHolder {
        return OneColumnViewHolder(
            ViewOneColumnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OneColumnViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE
    }
}


class OneColumnViewHolder(private val binding: ViewOneColumnBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: String, onClick: (String) -> Unit) {
        binding.textView.text = data
        binding.root.setOnClickListener { onClick(data) }
    }
}