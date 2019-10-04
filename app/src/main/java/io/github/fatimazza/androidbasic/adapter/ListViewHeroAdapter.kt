package io.github.fatimazza.androidbasic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

    private inner class ViewHolder(private val view: View) {
        fun bind(context: Context, hero: Hero) {
            with(view) {
                tv_item_name.text = hero.name
                tv_item_origin.text = hero.origin

                Glide.with(context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
            }
        }
    }
}
