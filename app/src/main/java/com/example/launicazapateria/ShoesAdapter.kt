package com.example.launicazapateria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shoe.view.*

class ShoesAdapter(
    private val shoes: List<Shoe>,
    private val onItemClick: (Shoe) -> Unit
) : RecyclerView.Adapter<ShoesAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoes[position]
        holder.bind(shoe)
    }

    override fun getItemCount(): Int {
        return shoes.size
    }

    inner class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(shoe: Shoe) {
            itemView.tvShoeName.text = shoe.name
            itemView.tvShoePrice.text = "$${shoe.price}"
            // Cargar la imagen del zapato en el ImageView (puedes usar bibliotecas de carga de imágenes)
            // itemView.ivShoeImage.load(shoe.imageUrl)

            itemView.setOnClickListener {
                onItemClick(shoe)
            }
        }
    }
}
