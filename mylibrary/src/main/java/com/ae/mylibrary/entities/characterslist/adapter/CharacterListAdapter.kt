package com.ae.mylibrary.entities.characterslist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.ae.mylibrary.R
import com.ae.mylibrary.common.dto.Result
import com.bumptech.glide.Glide

class CharacterListAdapter(private val results: List<Result>,
                           private val context: Context
):    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_item,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = results[position].name
        holder.species.text = results[position].species
        holder.status.text = results[position].status

        Glide
            .with(context)
            .load(results[position].image)
            .into(holder.image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.character_name)
        val species: TextView = itemView.findViewById(R.id.character_species)
        val status: TextView = itemView.findViewById(R.id.character_status)
        val image: ImageView = itemView.findViewById(R.id.character_image)
    }
}