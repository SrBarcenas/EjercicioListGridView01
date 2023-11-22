package com.example.listgridview.activitys

import adapter.FruitAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.listgridview.R
import model.Fruit

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapterLisView: FruitAdapter
    private lateinit var fruit: List<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        /*
        val names = ArrayList<String>()
        names.add("Iris")
        names.add("Nallely")
        names.add("Oscar")
        names.add("Alberto")

        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

         */


    }
}