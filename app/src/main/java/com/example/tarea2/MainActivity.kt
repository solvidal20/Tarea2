package com.example.tarea2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Esto carga el XML de arriba
        supportActionBar?.title = "T2: Diseño de una Aventura Interactiva"
        // carga el fragmento del mapa en el FrameLayout
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, WorldMapFragment()) // Usa el ID del FrameLayout
                .commit()
        }
        val allDishes = listOf(
            "Tacos al Pastor",
            "Enchiladas",
            "Pozole",
            "Asado",
            "Poutine",
            "Tourtière",
            "Carne Ahumada de Montreal",
            "Feijoada",
            "Moqueca",
            "Churrasco",
            "Bandeja Paisa",
            "Ajiaco Santafereño",
            "Arepa",
            "Empanadas",
            "Milanesa",
            "Hamburguesa",
            "Hot Dog",
            "Mac & Cheese"
        )
        val fabRandom: FloatingActionButton = findViewById(R.id.fab_random_dish)

        fabRandom.setOnClickListener {
            // 3. Elegimos un platillo al azar de la lista
            val randomDish = allDishes.random()

            // 4. Creamos el Intent para ir DIRECTO al Nivel 3
            val intent = Intent(this, DishDetailActivity::class.java).apply {

                putExtra("DISH_NAME", randomDish)
            }

            // 6. Lanzamos la actividad
            startActivity(intent)
        }
    }
}