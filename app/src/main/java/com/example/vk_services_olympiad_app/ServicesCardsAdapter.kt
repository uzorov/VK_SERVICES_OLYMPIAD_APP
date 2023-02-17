package com.example.vk_services_olympiad_app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_services_olympiad_app.databinding.VkItemBinding
import com.example.vk_services_olympiad_app.model.Item


class ServicesCardsAdapter(val itemClickListener: (View, Int, Int) -> Unit) :
    ListAdapter<Item, ServicesCardsAdapter.ItemViewHolder>(DiffCallback) {


    class ItemViewHolder(
        private var binding: VkItemBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {

            binding.item = item
            binding.executePendingBindings()
            Log.d("binding", "6");
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            Log.d("binding", "2");
            return oldItem.iconUrl == newItem.iconUrl
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            Log.d("binding", "3");
            return oldItem.description == newItem.description
        }
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {

        Log.d("binding", "4");
        val viewHolder = ItemViewHolder(
            VkItemBinding.inflate(LayoutInflater.from(parent.context))
        )
        viewHolder.onClick(itemClickListener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.d("binding", "5");
        val item = getItem(position)
        holder.bind(item)
    }

    fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(it, getAdapterPosition(), getItemViewType())
        }
        return this
    }
}
