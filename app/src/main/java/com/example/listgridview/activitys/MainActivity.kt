package com.example.listgridview.activitys

import adapter.FruitAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import com.example.listgridview.R
import model.Fruit

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var gridView: GridView
    private lateinit var adapterLisView: FruitAdapter
    private lateinit var adapterGridView: FruitAdapter
    private lateinit var fruit: List<Fruit>
    private lateinit var itemListView: MenuItem
    private lateinit var itemGridView: MenuItem

    private val SWITCH_TO_LIST_VIEW = 0
    private val SWITCH_TO_GRID_VIEW = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Establece el ícono en la barra de acción y configura propiedades asociadas.
        enforceIconBar()

        // Obtiene una lista de objetos Fruit con información predefinida.
        fruit = getAllFruits()
        listView = findViewById(R.id.listView)
        gridView = findViewById(R.id.gridView)

        /*
        // Comentario: Crear una lista de nombres y asignarla a un ListView (comentado).
        val names = ArrayList<String>()
        names.add("Iris")
        names.add("Nallely")
        names.add("Oscar")
        names.add("Alberto")

        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

         */

        // Crea un adaptador personalizado para la vista de lista utilizando la lista de objetos Fruit.
        adapterLisView = FruitAdapter(this, R.layout.list_view_layout, fruit)
        // Crea un adaptador personalizado para la vista de cuadrícula utilizando la misma lista de objetos Fruit.
        adapterGridView = FruitAdapter(this, R.layout.grid_view_layout, fruit)

        // Asigna los adaptadores a las vistas correspondientes (ListView y GridView).
        listView.adapter = adapterLisView
        gridView.adapter = adapterGridView


    }

    private fun enforceIconBar(){
        // Establece el ícono en la barra de acción utilizando el recurso ic_launcher_new.
        supportActionBar?.setIcon(R.mipmap.ic_launcher_new)
        // Habilita la visualización del logo en la barra de acción.
        supportActionBar?.setDisplayUseLogoEnabled(true)
        // Habilita la visualización del ícono de inicio en la barra de acción.
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun getAllFruits() : List<Fruit> {
        // Crea y retorna una lista de objetos Fruit con información predefinida.
        return mutableListOf(
            Fruit("Platano", R.drawable.ic_banana, "México"),
            Fruit("Frambuesa", R.drawable.ic_raspberry, "Peru"),
            Fruit("Fresa", R.drawable.ic_strawberry, "Colombia"),
            Fruit("Cereza", R.drawable.ic_cherry, "Brasil"),
            Fruit("Manzana", R.drawable.ic_apple, "Argetina"),
            Fruit("Naranja", R.drawable.ic_orange, "Chile"),
            Fruit("Pera", R.drawable.ic_pear, "Canada"),
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla el menú de opciones desde el archivo de recursos option_menu.
        menuInflater.inflate(R.menu.option_menu, menu)
        // Obtiene referencias a los elementos del menú para su posterior manipulación.
        itemListView = menu!!.findItem(R.id.list_view)
        itemGridView = menu.findItem(R.id.grid_view)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.list_view -> {
                // Maneja la selección del elemento de menú "list_view" y cambia a la vista de lista.
                switchListGridView(SWITCH_TO_LIST_VIEW)
                return true
            }
            R.id.grid_view -> {
                // Maneja la selección del elemento de menú "grid_view" y cambia a la vista de cuadrícula.
                switchListGridView(SWITCH_TO_GRID_VIEW)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun switchListGridView(option: Int){
        if (option == SWITCH_TO_LIST_VIEW) {
            // Si queremos cambiar a list view, y el list view está en modo invisible...
            if (listView.visibility == View.INVISIBLE) {
                // ... escondemos el grid view, y enseñamos su botón en el menú de opciones
                gridView.visibility = View.INVISIBLE
                itemGridView.isVisible = true
                // no olvidamos enseñar el list view, y esconder su botón en el menú de opciones
                listView.visibility = View.VISIBLE
                itemListView.isVisible = false
            }
        } else if (option == SWITCH_TO_GRID_VIEW) {
            // Si queremos cambiar a grid view, y el grid view está en modo invisible...
            if (gridView.visibility == View.INVISIBLE) {
                // ... escondemos el list view, y enseñamos su botón en el menú de opciones
                listView.visibility = View.INVISIBLE
                itemListView.isVisible = true
                // no olvidamos enseñar el grid view, y esconder su botón en el menú de opciones
                gridView.visibility = View.VISIBLE
                itemGridView.isVisible = false
            }
        }
    }
}