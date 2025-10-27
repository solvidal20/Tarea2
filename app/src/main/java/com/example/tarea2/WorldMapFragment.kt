package com.example.tarea2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.content.Intent
import com.example.tarea2.databinding.FragmentWorldMapBinding

class WorldMapFragment : Fragment() {

    private var _binding: FragmentWorldMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorldMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("WorldMapFragment", "onViewCreated se ha ejecutado. Configurando listeners...")
        // Configurar el click para cada país
        // (Más adelante, esto lanzará el Nivel 2)

        binding.btnCanada.setOnClickListener {
            lanzarSelectorDePais("Canadá")
        }

        binding.btnUsa.setOnClickListener {
            lanzarSelectorDePais("EE.UU.")
        }

        binding.btnMexico.setOnClickListener {
            lanzarSelectorDePais("México")
        }

        binding.btnColombia.setOnClickListener {
            lanzarSelectorDePais("Colombia")
        }

        binding.btnBrazil.setOnClickListener {
            lanzarSelectorDePais("Brazil")
        }

        binding.btnArgentina.setOnClickListener {
            lanzarSelectorDePais("Argentina")
        }
    }

    // En WorldMapFragment.kt

    private fun lanzarSelectorDePais(pais: String) {
        Log.d("WorldMapFragment", "Clic en $pais")

        // ¡ESTE ES EL CÓDIGO QUE ABRE LA VENTANITA!
        val intent = Intent(requireContext(), CountryDetailActivity::class.java).apply {
            putExtra("PAIS_SELECCIONADO", pais)
        }
        startActivity(intent)

        // Transición creativa: Un "Fade" (desvanecimiento)
        requireActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}