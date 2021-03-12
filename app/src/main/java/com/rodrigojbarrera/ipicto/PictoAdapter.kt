package com.rodrigojbarrera.ipicto

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rodrigojbarrera.ipicto.databinding.PictoItemBinding

class PictoAdapter(private val pictoList: List<Pictograms>, private val itemClick: OnPictoClick) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPictoClick {
        fun onPictoClick(pictograms: Pictograms)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            PictoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PictoViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClick.onPictoClick(pictoList[position])
        }

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PictoViewHolder -> holder.bind(pictoList[position])
        }
    }

    override fun getItemCount(): Int = pictoList.size


    private inner class PictoViewHolder(
        val binding: PictoItemBinding,
        val context: Context
    ) : BaseViewHolder<Pictograms>(binding.root) {
        override fun bind(item: Pictograms) {
            Glide.with(context)
                .load("https://static.arasaac.org/pictograms/${item._id.toString()}/${item._id.toString()}_300.png")
                .centerCrop().into(binding.imgPicto)

            binding.txtPicto.text = item.keywords.toString().replace("[", "").replace("]", "").toUpperCase()
        }
    }
}