package io.sharan.playstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.sharan.playstore.databinding.ViewHorizontalBinding

class HorizontalAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<String, HorizontalViewHolder>(StringDiffCallback) {

    companion object {
        const val VIEW_TYPE = 444
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return HorizontalViewHolder(
            ViewHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

}

class HorizontalViewHolder(
    private val binding: ViewHorizontalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, onClick: (String) -> Unit) {
        binding.textView.text = data
        binding.root.setOnClickListener { onClick(data) }
    }
}