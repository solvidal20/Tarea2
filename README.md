# T2: Diseño de una Aventura Interactiva
## 🌎 Experiencia Gastronómica en América 🍜

Esta es una aplicación para Android desarrollada como parte de la tarea de Desarrollo de Aplicaciones Móviles Nativas. El proyecto demuestra una navegación jerárquica de 3 niveles, cada uno implementado en una `Activity` separada, con una temática de exploración culinaria por el continente americano.
---
Elaborado por: Beltrán Vidal Sol Jarelly
---

## 📸 Capturas de Pantalla

| Nivel 1: Mapa Principal | Nivel 2: Lista de Platillos | Nivel 3: Detalle del Platillo |
| :---: |:---:|:---:|
| <img width="260" height="525" alt="studio64_0WDAUcxa2a" src="https://github.com/user-attachments/assets/0ce08647-94ec-4a7a-9da1-6cbc8bf320c5" /> | <img width="258" height="522" alt="studio64_qAn1rdktR6" src="https://github.com/user-attachments/assets/395e98f9-395a-4f9f-9bef-af6225919178" /> | <img width="261" height="522" alt="studio64_bcOXC2Irpy" src="https://github.com/user-attachments/assets/411b4ac0-432b-44ed-b370-ffc17dcb1509" /> |


---

## 🚀 Instrucciones de Ejecución

1.  Clona este repositorio en tu máquina local:
    ```bash
    git clone [https://github.com/tu-usuario/Tarea2.git](https://github.com/tu-usuario/Tarea2.git)
    ```
2.  Abre el proyecto con Android Studio.
3.  Espera a que Gradle sincronice todas las dependencias del proyecto.
4.  Ejecuta la aplicación en un emulador de Android (API 24 o superior) o en un dispositivo físico.

---

## 🎨 Decisiones de Diseño y Transiciones

El diseño de la aplicación se centró en la simplicidad y en cumplir los requisitos de la tarea de forma clara.

* **Jerarquía de 3 Activities:** La navegación principal se basa en Activities separadas, tal como se solicitó, para demostrar el control del ciclo de vida y el paso de datos mediante `Intent`.
    * **Nivel 1 (`MainActivity`):** Muestra un mapa estático de América. Se decidió usar un `ImageView` con `Button` invisibles superpuestos en lugar de una API como Google Maps para mantener el proyecto ligero y centrado en la navegación, no en la funcionalidad de mapas.
    * **Nivel 2 (`CountryDetailActivity`):** Originalmente se diseñó como una "ventanita" (Activity-Dialogo), pero se re-implementó como una pantalla completa para simplificar la depuración y asegurar un flujo de usuario más claro.
    * **Nivel 3 (`DishDetailActivity`):** Una pantalla de detalle clásica que muestra la imagen y descripción del platillo.

* **Mecanismos de Transición:** Para mantener la simplicidad, se utilizaron transiciones `fade_in` / `fade_out` (`android.R.anim`) entre las Activities. Esto proporciona una transición limpia y profesional sin necesidad de crear animaciones XML personalizadas.

* **Funcionalidad Extra:** Se añadió un `FloatingActionButton` ("?") en la pantalla principal. Este botón selecciona un platillo al azar de una lista maestra y navega *directamente* al Nivel 3, demostrando una navegación no lineal.

---

## 💡 Retos y Soluciones

Durante el desarrollo, surgieron varios desafíos técnicos:

* **Reto 1: La "ventanita" (Nivel 2) se mostraba invisible o cargaba el layout incorrecto.**
    * **Solución:** Este fue el bug más persistente. Se debía a una combinación de errores:
        1.  El `themes.xml` del diálogo no estaba configurado correctamente.
        2.  El archivo `dialog_background.xml` no tenía un color sólido (era transparente).
        3.  La `CountryDetailActivity` estaba cargando el layout `activity_main.xml` por error en su `setContentView`.
    * **Decisión Final:** Se simplificó el requisito a una pantalla completa, eliminando la complejidad del tema de diálogo y resolviendo todos los bugs asociados.

* **Reto 2: El botón aleatorio `?` mostraba "Platillo no encontrado".**
    * **Solución:** El `Intent` de `MainActivity` enviaba el nombre del platillo con la clave `"DISH_NAME_ARG"`, mientras que `DishDetailFragment` esperaba recibirlo con la clave `"DISH_NAME"`. Se estandarizó la clave a `"DISH_NAME"` en `MainActivity` para que coincidiera.

* **Reto 3: Error de instalación `not enough space`.**
    * **Solución:** Se identificó que no era un error de código, sino que el dispositivo físico o emulador se había quedado sin espacio de almacenamiento. Se solucionó limpiando el caché del dispositivo.
