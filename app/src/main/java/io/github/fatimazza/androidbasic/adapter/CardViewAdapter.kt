package io.github.fatimazza.androidbasic.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.fatimazza.androidbasic.R
import io.github.fatimazza.androidbasic.model.Hero

class CardViewAdapter(private val listHeroes: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewAdapter.CardviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardviewViewHolder {
        val view: View = LayoutInflater
            .from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardviewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: CardviewViewHolder, position: Int) {
        val (name, origin, photo) = listHeroes[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvOrigin.text = origin

        holder.btnFavorite.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Favorite " + listHeroes[holder.adapterPosition].name, Toast.LENGTH_LONG
            ).show()
        }
        holder.btnShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share " + listHeroes[holder.adapterPosition].name, Toast.LENGTH_LONG
            ).show()
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu memilih " + listHeroes[holder.adapterPosition].name, Toast.LENGTH_LONG
            ).show()
        }
    }

    inner class CardviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvOrigin: TextView = itemView.findViewById(R.id.tv_item_origin)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_share)
    }

}
