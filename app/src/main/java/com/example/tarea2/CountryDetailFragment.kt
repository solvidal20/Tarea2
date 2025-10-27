package com.example.tarea2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tarea2.databinding.FragmentCountryDetailBinding // Importa el ViewBinding

class CountryDetailFragment : Fragment() {

    // 1. Configuración de ViewBinding
    private var _binding: FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Leer el nombre del país de los argumentos
        val countryName = arguments?.getString("COUNTRY_NAME") ?: "País no encontrado"

        // 3. Configurar la UI con la info del país
        binding.tvCountryName.text = countryName

        // 4. Lógica para mostrar los platillos (con datos de ejemplo)
        when (countryName) {
            "México" -> {
                binding.btnPlatillo1.text = "Tacos al Pastor"
                binding.btnPlatillo2.text = "Enchiladas"
                binding.btnPlatillo3.text = "Pozole"
            }
            "Argentina" -> {
                binding.btnPlatillo1.text = "Asado"
                binding.btnPlatillo2.text = "Empanadas"
                binding.btnPlatillo3.text = "Milanesa"
            }
            "EE.UU." -> {
                binding.btnPlatillo1.text = "Hamburguesa"
                binding.btnPlatillo2.text = "Hot Dog"
                binding.btnPlatillo3.text = "Mac & Cheese"
            }
            "Canadá" -> {
                binding.btnPlatillo1.text = "Poutine"
                binding.btnPlatillo2.text = "Tourtière"
                binding.btnPlatillo3.text = "Carne Ahumada"
            }
            "Brazil" -> {
                binding.btnPlatillo1.text = "Feijoada"
                binding.btnPlatillo2.text = "Moqueca"
                binding.btnPlatillo3.text = "Churrasco"
            }
            "Colombia" -> {
                binding.btnPlatillo1.text = "Bandeja Paisa"
                binding.btnPlatillo2.text = "Ajiaco Santafereño"
                binding.btnPlatillo3.text = "Arepa"
            }
            else -> {
                // Oculta los botones si no hay datos
                binding.btnPlatillo1.visibility = View.GONE
                binding.btnPlatillo2.visibility = View.GONE
                binding.btnPlatillo3.visibility = View.GONE
            }
        }

        // 5. Configurar los Click Listeners

        // Botón de Cerrar
        binding.btnClose.setOnClickListener {

            activity?.finish()
        }

        // Botones de platillos (lanzan el Nivel 3)
        binding.btnPlatillo1.setOnClickListener {
            lanzarNivel3(binding.btnPlatillo1.text.toString())
        }
        binding.btnPlatillo2.setOnClickListener {
            lanzarNivel3(binding.btnPlatillo2.text.toString())
        }
        binding.btnPlatillo3.setOnClickListener {
            lanzarNivel3(binding.btnPlatillo3.text.toString())
        }
    }

    // 6. Función para lanzar el Nivel 3
    private fun lanzarNivel3(nombrePlatillo: String) {
        val intent = Intent(activity, DishDetailActivity::class.java).apply {
            putExtra("DISH_NAME", nombrePlatillo)
        }
        startActivity(intent)

        // Transición creativa: Un "Fade" (desvanecimiento)
        activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }   


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}