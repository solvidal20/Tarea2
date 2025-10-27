package com.example.tarea2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Carga el layout de la Activity (el que tiene la "tarjeta" contenedora)
        setContentView(R.layout.activity_country_detail)

        // 2. Obtenemos el nombre del país que enviamos desde el Nivel 1 (WorldMapFragment)
        val countryName = intent.getStringExtra("PAIS_SELECCIONADO") ?: "País Desconocido"

        // 3. Este 'if' evita que el fragmento se cargue múltiples veces
        // si la actividad se recrea (ej. al girar la pantalla).
        if (savedInstanceState == null) {

            // 4. Creamos una instancia del fragmento que mostrará el contenido
            val fragment = CountryDetailFragment().apply {

                // 5. Usamos 'arguments' para pasarle el nombre del país al fragmento
                arguments = Bundle().apply {
                    // La clave aquí debe coincidir con la que el fragmento espera
                    putString("COUNTRY_NAME", countryName)
                }
            }

            // 6. Finalmente, cargamos el fragmento en el contenedor
            supportFragmentManager.beginTransaction()
                // Usamos el ID del FrameLayout que está en activity_country_detail.xml
                .replace(R.id.fragment_container_country, fragment)
                .commit()
        }
    }
}