package io.github.fatimazza.androidbasic.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.fatimazza.androidbasic.R
import io.github.fatimazza.androidbasic.model.Hero

class GridHeroAdapter(val listHeroes: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridHeroAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_hero, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
