package io.sharan.playstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.sharan.playstore.databinding.ViewTwoColumnBinding

class TwoColumnAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<String, TwoColumnViewHolder>(StringDiffCallback) {

    companion object {
        val VIEW_TYPE = 888
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoColumnViewHolder {
        return TwoColumnViewHolder(
            ViewTwoColumnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TwoColumnViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE
    }

}


class TwoColumnViewHolder(private val binding: ViewTwoColumnBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, onClick: (String) -> Unit) {
        binding.textView.text = data
        binding.root.setOnClickListener { onClick(data) }
    }
}