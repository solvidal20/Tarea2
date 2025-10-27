package com.example.tarea2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DishDetailActivity : AppCompatActivity() {
    // Dentro de DishDetailActivity.kt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)

        // Obtenemos el nombre del platillo del Nivel 2
        val dishName = intent.getStringExtra("DISH_NAME")

        if (savedInstanceState == null) {
            val fragment = DishDetailFragment().apply {
                // Pasamos el nombre del platillo al fragmento
                arguments = Bundle().apply {
                    putString("DISH_NAME_ARG", dishName)
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_dish, fragment)
                .commit()
        }
    }
}