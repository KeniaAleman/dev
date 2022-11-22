package com.example.recyclerviewdemok

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//passing a function, lamba expressions
class MyRecyclerViewAdapter(private val countriesList:List<Country>,
                            private val clickListener: (Country) -> Unit)
                            : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val country = countriesList[position]
        holder.bind(country, clickListener)
    }

    override fun getItemCount(): Int {
        return countriesList.size;
    }
}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){

    fun bind(country: Country, clickListener: (Country) -> Unit) {

        val myTvName: TextView = view.findViewById<TextView>(R.id.tvName)
        myTvName.text = "Country: ${country.name}"

        val myTvVisited: TextView = view.findViewById<TextView>(R.id.tvVisited)
        myTvVisited.text = "Visited: ${country.visited}"

        view.setOnClickListener{
            clickListener(country)
        }

    }
}