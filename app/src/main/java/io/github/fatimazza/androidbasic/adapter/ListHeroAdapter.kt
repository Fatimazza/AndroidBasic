package io.github.fatimazza.androidbasic.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.fatimazza.androidbasic.R
import io.github.fatimazza.androidbasic.model.Hero

class ListHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, origin, photo) = listHero[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvOrigin.text = origin
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvOrigin: TextView = itemView.findViewById(R.id.tv_item_origin)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
