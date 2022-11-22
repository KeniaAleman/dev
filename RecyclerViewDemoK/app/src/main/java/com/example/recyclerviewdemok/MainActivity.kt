 package com.example.recyclerviewdemok

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

 class MainActivity : AppCompatActivity() {
     val countriesList = listOf<Country>(
         Country("USA", "yes"),
         Country("Spain", "yes"),
         Country("Mexico", "yes"),
         Country("Bahamas", "yes"),
         Country("Jamaica", "yes"),
         Country("Colombia", "yes"),
         Country("Greece", "no")
         )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.WHITE)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // pass the function to the adapter below
        recyclerView.adapter = MyRecyclerViewAdapter(countriesList,
        ) { selectedItem: Country ->
            listItemClicked(selectedItem)
        }
    }

     //higher order functions, lamba expressions or function references
     private fun listItemClicked(country: Country){
         Toast.makeText(this@MainActivity, "Selected Country is : ${country.name}", Toast.LENGTH_SHORT).show()
     }
}