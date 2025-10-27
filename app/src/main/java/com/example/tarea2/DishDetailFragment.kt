package com.example.tarea2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tarea2.databinding.FragmentDishDetailBinding 

class DishDetailFragment : Fragment() {

    // 1. Configuración de ViewBinding
    private var _binding: FragmentDishDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDishDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Recibir el nombre del platillo
        val dishName = arguments?.getString("DISH_NAME_ARG") ?: "Platillo no encontrado"

        // 3. Cargar los datos del platillo
        loadDishData(dishName)
    }

    private fun loadDishData(dishName: String) {
        // Usamos 'binding' para acceder a las Vistas del XML
        binding.tvDishName.text = dishName

        // 4. Lógica para mostrar la info correcta
        when (dishName) {
            "Tacos al Pastor" -> {
                binding.ivDishImage.setImageResource(R.drawable.tacos_pastor)
                binding.tvDishCaption.text = "Carne de cerdo adobada cocinada en un trompo vertical, servida en tortillas de maíz con piña, cilantro y cebolla. Un clásico de la Ciudad de México."
            }
            "Enchiladas" -> {
                binding.ivDishImage.setImageResource(R.drawable.enchiladas)
                binding.tvDishCaption.text = "Tortillas de maíz bañadas en salsa de chile, rellenas de pollo, queso o frijoles, y usualmente acompañadas de crema y queso."
            }
            "Pozole" -> {
                binding.ivDishImage.setImageResource(R.drawable.pozole)
                binding.tvDishCaption.text = "El pozole es una emblemática sopa mexicana hecha con grandes granos de maíz \"floreados\" y carne de cerdo o pollo. Su caldo define su sabor: puede ser Rojo (sazonado con chiles secos), Blanco (puro) o Verde (con tomatillos). Es un platillo festivo que se personaliza al momento de servir con lechuga, rábanos, orégano y limón, acompañado de tostadas.."
            }
            "Hamburguesa" -> {
                binding.ivDishImage.setImageResource(R.drawable.hamburguesa)
                binding.tvDishCaption.text = "Carne molida cocida, servida dentro de un panecillo, comúnmente acompañada de queso, lechuga, tomate y salsas."
            }
            "Hot Dog" -> {
                binding.ivDishImage.setImageResource(R.drawable.hot_dog)
                binding.tvDishCaption.text = "Consiste en una salchicha cocida, servida en un panecillo suave y alargado. Su verdadera esencia radica en la personalización, transformándose con toppings que van desde la clásica mostaza y kétchup hasta chili, queso y cebolla. Es el sabor indispensable de los estadios de béisbol y las barbacoas."
            }
            "Mac & Cheese" -> {
                binding.ivDishImage.setImageResource(R.drawable.mac_cheese)
                binding.tvDishCaption.text = "El máximo comfort food estadounidense, consiste en pasta de coditos bañada en una salsa de queso cremosa, comúnmente cheddar. Puede ser una preparación rápida de estufa o una versión horneada con una costra dorada. Es la guarnición estrella en barbacoas y comidas familiares."
            }
            "Poutine" -> {
                binding.ivDishImage.setImageResource(R.drawable.poutine)
                binding.tvDishCaption.text = "Originaria de Quebec, es la comida rápida icónica de Canadá. Es una base de papas fritas crujientes, cubiertas con cuajo de queso fresco. Justo antes de servir, se baña todo con una salsa de carne caliente que derrite parcialmente el queso."
            }
            "Tourtière" -> {
                binding.ivDishImage.setImageResource(R.drawable.tourtiere)
                binding.tvDishCaption.text = "Un pastel de carne tradicional franco-canadiense, especialmente popular durante las festividades. Consiste en una masa de hojaldre o quebrada rellena de carne molida (usualmente cerdo, res o una mezcla) sazonada con especias. Es un plato sustancioso y reconfortante."
            }
            "Carne Ahumada" -> {
                binding.ivDishImage.setImageResource(R.drawable.carne_ahumada)
                binding.tvDishCaption.text = "Un ícono de Montreal, esta carne es pecho de res curado, ahumado y sazonado con especias. Se corta en finas rebanadas y se sirve caliente, apilado generosamente en un sándwich de pan de centeno. Se acompaña clásicamente solo con mostaza amarilla."
            }
            "Feijoada" -> {
                binding.ivDishImage.setImageResource(R.drawable.feijoada)
                binding.tvDishCaption.text = "Considerado el plato nacional de Brasil, la Feijoada es un guiso robusto y oscuro de frijoles negros. Se cocina lentamente con una variedad de carnes de cerdo, como salchichas, costillas y carne seca. Se sirve tradicionalmente con arroz, farofa (harina de yuca tostada) y col rizada."
            }
            "Moqueca" -> {
                binding.ivDishImage.setImageResource(R.drawable.moqueca)
                binding.tvDishCaption.text = "Un vibrante guiso de pescado y/o mariscos de la costa de Brasil, cocido lentamente en una olla de barro. Su base cremosa se logra sin agua, usando solo leche de coco, tomate, pimientos y el característico aceite de palma (dendê). Es un platillo aromático que captura la esencia tropical del país."
            }
            "Churrasco" -> {
                binding.ivDishImage.setImageResource(R.drawable.churrasco)
                binding.tvDishCaption.text = "Es el estilo de parrillada brasileña por excelencia, donde la carne es la estrella. Grandes cortes, especialmente la Picanha (tapa de cuadril), se ensartan en espadas y se asan lentamente sobre brasas. En las \"churrascarías\", los meseros sirven la carne directamente en tu plato."
            }
            "Bandeja Paisa" -> {
                binding.ivDishImage.setImageResource(R.drawable.moqueca)
                binding.tvDishCaption.text = "Un plato insignia de la región de Antioquia, famoso por su generosa abundancia. Es una \"bandeja\" que combina frijoles rojos, arroz, chicharrón crujiente, carne molida, chorizo y huevo frito. Se corona con tajadas de plátano maduro, aguacate y una pequeña arepa."
            }
            "Ajiaco Santafereño" -> {
                binding.ivDishImage.setImageResource(R.drawable.ajiaco)
                binding.tvDishCaption.text = "La sopa emblemática de Bogotá, un caldo espeso y reconfortante. Su textura cremosa proviene de tres tipos de papa (incluyendo la papa criolla) y su sabor único de la hierba guascas. Se sirve con pollo desmechado, mazorca, y se acompaña de crema de leche y alcaparras."
            }
            "Arepa" -> {
                binding.ivDishImage.setImageResource(R.drawable.arepa)
                binding.tvDishCaption.text = "El pan de cada día en Colombia y Venezuela, hecho de masa de maíz molido y asado en plancha. Su versatilidad es total: se come sola con mantequilla, como acompañamiento, o se abre y rellena. Los rellenos van desde queso fresco hasta carne desmechada, aguacate o huevo."
            }
            "Asado" -> {
                binding.ivDishImage.setImageResource(R.drawable.asado)
                binding.tvDishCaption.text = "El corazón de la gastronomía argentina. Diferentes cortes de carne (principalmente de res) cocinados lentamente a la parrilla."
            }
            "Empanadas" -> {
                binding.ivDishImage.setImageResource(R.drawable.empanadas)
                binding.tvDishCaption.text = "Son el snack o entrada más popular de Argentina, un básico de reuniones sociales. Consisten en discos de masa rellenos, tradicionalmente de carne de res cortada a cuchillo, aunque también son populares las de jamón y queso, pollo o maíz. Se cocinan al horno o fritas, y su borde repulgado es su firma artesanal."
            }
            "Milanesa" -> {
                binding.ivDishImage.setImageResource(R.drawable.milanesa)
                binding.tvDishCaption.text = "Un plato fundamental en cualquier hogar argentino, adaptado de la receta italiana. Es una fina rebanada de carne de res (usualmente nalga o peceto) pasada por huevo batido y luego por pan rallado, que se fríe u hornea. Se sirve \"al plato\" (con papas fritas o puré) o como sándwich."
            }

            else -> {
                binding.tvDishCaption.text = "Descripción no disponible."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}