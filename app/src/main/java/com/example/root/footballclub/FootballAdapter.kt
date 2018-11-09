package com.example.root.footballclub

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

class FootballAdapter(var list: List<FootballClub>, var listener: (FootballClub) -> Unit ) :
        RecyclerView.Adapter<FootballAdapter.ViewHolder>(){


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position],listener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(FootballView().createView(AnkoContext.Companion.create(parent.context,parent)))

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

            val imageView = itemView.findViewById<ImageView>(FootballView.logo_club)
            val textView = itemView.findViewById<TextView>(FootballView.club_name)

        fun bindItem(items: FootballClub, listener: (FootballClub) -> Unit) {
            textView.text = items.nama_club
            Glide.with(itemView.context).load(items.logo).into(imageView)
            itemView.setOnClickListener {
                listener(items)
                Log.e("info", items.toString())
            }
        }

    }

}