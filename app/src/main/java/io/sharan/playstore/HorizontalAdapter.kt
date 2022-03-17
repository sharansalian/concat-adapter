package io.sharan.playstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.sharan.playstore.databinding.ViewHorizontalBinding

class HorizontalAdapter(val onClick: (String) -> Unit) :
    RecyclerView.Adapter<HorizontalViewHolder>() {

    private var data: List<String> = emptyList()

    companion object {
        const val VIEW_TYPE = 444
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return HorizontalViewHolder(
            ViewHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(data[position], onClick)
    }

    override fun getItemCount(): Int = data.size

    fun updateData(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
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