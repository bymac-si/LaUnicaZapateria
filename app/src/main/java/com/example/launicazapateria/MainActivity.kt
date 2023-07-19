package com.example.launicazapateria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    private val shoesList = listOf(
        Shoe(1, "Zapato 1", "Descripción del zapato 1", 59.99, "https://example.com/zapato1.jpg"),
        Shoe(2, "Zapato 2", "Descripción del zapato 2", 79.99, "https://example.com/zapato2.jpg"),
        // Agrega más zapatos aquí
    )

    private val cartItems = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = ShoesAdapter(shoesList, this::onShoeItemClick)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun onShoeItemClick(shoe: Shoe) {
        // Aquí puedes mostrar los detalles del zapato seleccionado
        // y permitir al usuario agregarlo al carrito de compras.
        // Puedes utilizar un cuadro de diálogo, otra actividad o un fragmento.
    }

    private fun addToCart(shoe: Shoe) {
        val existingItem = cartItems.find { it.shoe.id == shoe.id }

        if (existingItem != null) {
            existingItem.quantity++
        } else {
            cartItems.add(CartItem(shoe, 1))
        }

        // Actualizar la interfaz para reflejar los cambios en el carrito
        // Por ejemplo, mostrar el número de elementos en el carrito en un TextView.
    }
}
