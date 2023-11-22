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

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View? {
        val holder: ViewHolder
        var convertView = convertView

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null)

            holder = ViewHolder()
            holder.name = convertView.findViewById(R.id.textViewName)
            holder.country = convertView.findViewById(R.id.textViewCountry)
            holder.icon = convertView.findViewById(R.id.imageViewIcon)
            convertView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
        }

        val currentFruit = getItem(position)

        if(currentFruit is Fruit){
            holder.name.text = currentFruit.name
            holder.country.text = currentFruit.country
            holder.icon.setImageResource(currentFruit.icon)
        }

        return convertView
    }

    internal class ViewHolder {
        lateinit var name: TextView
        lateinit var country: TextView
        lateinit var icon: ImageView
    }
}