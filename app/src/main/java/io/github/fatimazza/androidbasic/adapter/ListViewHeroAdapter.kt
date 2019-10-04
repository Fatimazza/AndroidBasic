package io.github.fatimazza.androidbasic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.fatimazza.androidbasic.R
import io.github.fatimazza.androidbasic.model.Hero
import kotlinx.android.synthetic.main.item_row_hero.view.*


class ListViewHeroAdapter(val context: Context, val listHero: ArrayList<Hero>) : BaseAdapter() {

    override fun getItem(i: Int): Any {
        return listHero[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return listHero.size
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewLayout = LayoutInflater.from(context)
            .inflate(R.layout.item_row_hero, viewGroup, false)

        val viewHolder = ViewHolder(viewLayout)
        val hero = getItem(i) as Hero
        viewHolder.bind(context, hero)
        return viewLayout
    }

    private inner class ViewHolder(view: View) {

        private val txtName: TextView = view.tv_item_name
        private val txtDescription: TextView = view.tv_item_origin
        private val imgPhoto: ImageView = view.img_item_photo

        fun bind(context: Context, hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.origin

            Glide.with(context)
                .load(hero.photo)
                .apply(RequestOptions().override(55, 55))
                .into(imgPhoto)
        }
    }
}
