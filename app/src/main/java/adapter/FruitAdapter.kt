package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listgridview.R
import model.Fruit

class FruitAdapter(
    private val context: Context,
    private val layout: Int,
    private val list: List<Fruit>
) : BaseAdapter(){

    // La función getCount() devuelve el número de elementos en la lista.
    override fun getCount(): Int {
        return list.size
    }

    // La función getItem() devuelve el objeto en la posición especificada.
    override fun getItem(position: Int): Any {
        return list[position]
    }

    // La función getItemId() devuelve un identificador único para el objeto en la posición especificada.
    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    // La función getView() se encarga de crear y retornar la vista para un elemento en una posición dada.
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View? {
        // Se declara un objeto ViewHolder para contener las referencias a las vistas de un elemento.
        val holder: ViewHolder
        // Se utiliza la vista reciclada (convertView) si está disponible, de lo contrario se infla una nueva.
        var convertView = convertView

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null)

            // Se crea un nuevo ViewHolder y se asignan las referencias de las vistas a sus respectivos atributos.
            holder = ViewHolder()
            holder.name = convertView.findViewById(R.id.textViewName)
            holder.country = convertView.findViewById(R.id.textViewCountry)
            holder.icon = convertView.findViewById(R.id.imageViewIcon)
            // Se establece el ViewHolder como una etiqueta en la vista convertida para su reutilización.
            convertView.tag = holder
        }else{
            // Si la vista ya existe, se obtiene el ViewHolder de la etiqueta.
            holder = convertView.tag as ViewHolder
        }

        // Se obtiene el objeto correspondiente a la posición actual.
        val currentFruit = getItem(position)

        // Se verifica si el objeto es del tipo Fruit.
        if(currentFruit is Fruit){
            // Se actualizan las vistas en el ViewHolder con la información del objeto Fruit.
            holder.name.text = currentFruit.name
            holder.country.text = currentFruit.country
            holder.icon.setImageResource(currentFruit.icon)
        }

        // Se devuelve la vista actualizada.
        return convertView
    }

    // Clase interna que representa un ViewHolder, contiene referencias a las vistas de un elemento.
    internal class ViewHolder {
        lateinit var name: TextView
        lateinit var country: TextView
        lateinit var icon: ImageView
    }
}